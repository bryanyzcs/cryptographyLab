package certification.core;

import certification.core.query.PathQuery;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**.
 * Handle the request from client.
 */
public class Handler {
    /**
     * Request entry
     *
     * @param pkPath  -client pk local path
     * @param request - request information
     * @return cert's path if succeed to sign, "reject" if fail to sign.
     */
    public String requestHandler(String pkPath, Request request) {
        GenCer genCer = new GenCer(request);
        String crtPath = genCer.signPublickeyAndRequest(pkPath, request);
        if (crtPath.equals("reject")) {
            System.out.println("Failed to sign.");
        }
        return crtPath;
    }

    /**
     * Certificate verified.
     * 弃用
     * @return
     */
    public String certVerifiedHandler(String crtPath) {
        X509Certificate x509Certificate = null;
        X509Certificate caCert = null;
        CertificateFactory certificateFactory = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(crtPath);
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
            fileInputStream = new FileInputStream(PathQuery.caCrtPath);
            caCert = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
            PublicKey publicKey = caCert.getPublicKey();
            x509Certificate.verify(publicKey);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "No Such Algorithm";
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "Invalid Key";
        } catch (SignatureException e) {
            e.printStackTrace();
            return "Signature Invalid";
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return "No Such Provider";
        }
        return "Signature Valid";
    }

    /**
     * Scan the crts' repository to find the expired crt to revoke.
     *
     * @return true if something done(eg,update certs and crl), otherwise false.
     */
    public boolean timeoutHandler() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        boolean flag = false;//sql change
        // 注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificationsystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");

            st = conn.createStatement();
            // 查询
            String sql = "select * from certs";
            rs = st.executeQuery(sql);
            // 遍历
            while (rs.next()) {
                String crtPath = rs.getString("fileName");
                String serial = rs.getString("serial");
                String commonName = rs.getString("commonName");
                System.out.println(crtPath);
                if (checkValidity(crtPath)){//cert has expired
                    System.out.println("Certifcate " + serial + " has expired");
                    flag = true ;

                    String delete = "delete from certs where serial="+"'"+serial+"'";
                    if(st.executeUpdate(delete)!=0){
                        System.out.println("Delete successfully from the certificate repository!");
                    } else {
                        System.out.println("Fail to delete!");
                    }
                    CRL crl = new CRL();
                    if(crl.doCRL(crtPath,commonName,serial)){
                        System.out.println("Add to certificate revocation list successfully!");
                    }
                } else {
                    System.out.println("Certifcate " + serial + " hasn't expired");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
    }

    /**
     * Check the validity of cert.
     * @cerPath -the cert's path.
     * @return true if crt has not expired, otherwise false
     */
    private boolean checkValidity(String cerPath) {
        File file = new File(cerPath);
        boolean checkV = false;
        try {
            BufferedReader  in = new BufferedReader(new FileReader(file));
            String nextLine = null;
            while ((nextLine = in.readLine())!=null){
                if(nextLine.contains("Not After:")){
                    String[] split = nextLine.split("Not After:");
                    Date dateNow = new Date();
                    Date datNoteAfter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(split[0]);
                    if (dateNow.compareTo(datNoteAfter)<0){
                        checkV = true;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return checkV;
    }
}