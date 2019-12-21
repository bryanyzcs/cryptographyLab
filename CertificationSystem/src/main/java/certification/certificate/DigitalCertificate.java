package certification.certificate;

import certification.core.query.PathQuery;

import java.io.*;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 数字证书类型
 */
public class DigitalCertificate {
    private String Subject;//使用者
    private String Version = "1";//证书版本
    private String Serial;//序列号
    private String SignAlgorithm;//签名算法
    private String PublicKey;//公钥
    private String Exponent = "65535";//公钥参数
    private String HashAlgorithm;// 签名哈希算法
    private String Issuer;//发行者名称
    private Date PublishingTime;//起始时间
    private String Validity;//有效期
    private String Sign;//签名


    private String getNotAfter(){
        Date date = new Date(this.PublishingTime.getTime()+(long)(Integer.parseInt(Validity)* 24 * 60 * 60 * 1000));
        return date.toString();
    }

    public String getinfo() {
        final String version = "Version:"+Version;
        final String serial = "Serial Number:"+Serial;
        final String signAlgorithm = "Signature Algorithm:"+SignAlgorithm;
        final String issuer = "Issuer:"+Issuer;
        final String notBefore = "Not Before:"+PublishingTime.toString();

        final String notAfter = "Not After:"+getNotAfter();
        final String subject = "Subject:"+Subject;
        final String publicKey = "Subject Public Key Info:"+PublicKey;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(version+serial+signAlgorithm+issuer+notBefore+notAfter+subject+publicKey);
        return stringBuffer.toString();
    }
    /**
     * Write certificate info to the file
     */
    public String genCertificate() {
        final String version = "Version:"+Version;
        final String serial = "\nSerial Number:"+Serial;
        final String signAlgorithm = "\nSignature Algorithm:"+SignAlgorithm;
        final String issuer = "\nIssuer:"+Issuer;
        final String notBefore = "\nNot Before:"+PublishingTime.toString();

        final String notAfter = "\nNot After:"+getNotAfter();
        final String subject = "\nSubject:"+Subject;
        final String publicKey = "\nSubject Public Key Info:"+PublicKey;
        final String sign = "\nSignature:"+Sign;
        String path = PathQuery.democaPath+ PathQuery.certsPath+Serial+".txt";
        File file = new File(path);
        try {
            if(!file.exists()){
                    file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(version+serial+signAlgorithm+issuer+notBefore+notAfter+subject+publicKey+sign);
            //Rsa rsa = new Rsa();
            System.out.println(stringBuffer.toString());
            //String writeto = rsa.base64Encode(stringBuffer.toString().getBytes());
            bufferedWriter.write(stringBuffer.toString());
            setLocalSerialNumber();
            bufferedWriter.close();
            writeCertToSql(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Reject！";
        } catch (IOException e) {
            e.printStackTrace();
            return "Reject！";
        }
        return path;
    }

    /**
     * Store the certificate to sql
     * @param fileName  -name of new cert
     * @return -true if store successful.
     */
    private boolean writeCertToSql(String fileName){
        Connection conn = null;
        Statement st = null;
        // 注册驱动
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/certificationsystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");

            st = conn.createStatement();
            //写入
            String[] split = fileName.split("\\\\");
            fileName = split[0];
            for (int i=1;i<split.length;i++){
                fileName += "\\\\" + split[i];
            }
            String[] split1 = Subject.split("CN=");
            String value = "(\'"+split1[1].split(",")[0]+"\', \'"+Serial+"\', \'"+fileName+"\')";
            String writeToSql = "insert into certs (commonName, serial, fileName) values "+value;
            System.out.println(writeToSql);
            // 查询
            //String sql = "select * from certs";
            int rs;
            rs = st.executeUpdate(writeToSql);
            if (rs!=0){
                System.out.println("Succeed to insert！");
            } else {
                System.out.println("Fail to insert！");
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    /**
     * If succeed to generate a certificate then ++serial number at local
     */
    private void setLocalSerialNumber(){
        File file = new File(PathQuery.serialPath);
        String serialString = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                int serial = Integer.parseInt(line)+1;
                serialString = serial+"";
                if (serialString.length()==1){
                    serialString = "0"+serialString;
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(serialString);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }



    /**
     * Read the next serial number from serial file
     * @return the serial;
     */
    private String getSerialFromFile(){
        String serial = null;
        File file = new File(PathQuery.serialPath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            serial = reader.readLine();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serial;
    }


    /**
     * read issuer from local caCert
     * @return
     */
    private String getBodyFromFile(){
        String path = PathQuery.caCrtPath;
        File file = new File(path);
        String issuer = null;
        try {
            FileInputStream in = new FileInputStream(file);
            X509Certificate x509Certificate = null;
            CertificateFactory x509Factory = CertificateFactory.getInstance("X.509");
            x509Certificate = (X509Certificate) x509Factory.generateCertificate(in);
            Principal body = x509Certificate.getIssuerDN();
            issuer = body.toString();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return issuer;
    }


    public DigitalCertificate(String subject) {
        this.Subject = subject;
        this.Serial = getSerialFromFile();
        this.Issuer = getBodyFromFile();
        this.HashAlgorithm = "sha1";
        this.SignAlgorithm = "sha1WithRSAEncryption";
        this.PublishingTime = new Date();
        this.Validity = "365";
        this.Sign = "";
        this.PublicKey = null;
    }


    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public void setSignAlgorithm(String signAlgorithm) {
        SignAlgorithm = signAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        HashAlgorithm = hashAlgorithm;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
    }


    public void setValidity(String validity) {
        Validity = validity;
    }

    public void setBodyName(String bodyName) {
        Issuer = bodyName;
    }

    public void setPublicKey(String publicKey) {
        PublicKey = publicKey;
    }

    public void setPublicKeyParameter(String publicKeyParameter) {
        Exponent = publicKeyParameter;
    }


    public String getSubject() {
        return Subject;
    }

    public String getVersion() {
        return Version;
    }

    public String getSerial() {
        return Serial;
    }

    public String getSignAlgorithm() {
        return SignAlgorithm;
    }

    public String getHashAlgorithm() {
        return HashAlgorithm;
    }

    public String getIssuer() {
        return Issuer;
    }

    public String getPublishingTime() {
        return PublishingTime.toString();
    }

    public String getValidity() {
        return Validity;
    }

    public String getBodyName() {
        return Issuer;
    }

    public String getPublicKey() {
        return PublicKey;
    }

    public String getPublicKeyParameter() {
        return Exponent;
    }


}
