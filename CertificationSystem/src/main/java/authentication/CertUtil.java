package authentication;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * 证书解析
 */
public class CertUtil {
    private final String RepoPath = "E:\\CertifacateRepo\\";
    private final String repoPath = "E:\\OpenSSL-Win64\\demoCA\\certs\\";
    //decode
    public void baseToASCII(String path){
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            System.out.println(file.length());
            fileInputStream.read(buffer);
            fileInputStream.close();
            String base = new String(buffer,"UTF-8");
            String base64 = base.substring(29,base.length()-29);
            System.out.println(base64);
            byte[] dec;//Base64Decoder.decode(buffer,0,buffer.length-1);
//            Base64.Decoder decoder = Base64.getMimeDecoder();
//            dec = decoder.decode(buffer);
//            dec = Base64Decoder.decode(buffer,29,buffer.length -29);
            System.out.println("Dec: ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public X509Certificate genCertificate(String certName){
        X509Certificate x509Certificate = null;
        StringBuffer cmd = new StringBuffer();
        cmd.append("E:\\jdk1.8.0_211\\bin\\");
        cmd.append("keytool -genkey -v -alias weblogicssl -keyalg RSA -keysize 1024 -validity 365 ");
        cmd.append("-keystore C:/weblogic.jks ");
        cmd.append("-keypass 123456789 -storepass 123456789 ");
        cmd.append("-dname \"CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn\"");
        try {
            Process ps = Runtime.getRuntime().exec(cmd.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @cerPath Java读取Cer证书信息
     * @throws Exception
     * @return X509Cer对象
     */
    public X509Certificate getX509CerCate(String cerPath) throws Exception {
        X509Certificate x509Certificate = null;
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        FileInputStream fileInputStream = new FileInputStream(cerPath);
//        byte[] b = new byte[10000];
//        fileInputStream.read(b);
//        String newString = new String(b);
//        System.out.println("File content contains:\n"+ newString);
        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);

        System.out.println("读取Cer证书信息...");

        System.out.println("x509Certificate_SerialNumber_序列号___:"+x509Certificate.getSerialNumber());
        System.out.println("x509Certificate_getIssuerDN_发布方标识名___:"+x509Certificate.getIssuerDN().toString());
        System.out.println("x509Certificate_getSubjectDN_主体标识___:"+x509Certificate.getSubjectDN());
        System.out.println("x509Certificate_getSigAlgOID_证书算法OID字符串___:"+x509Certificate.getSigAlgOID());
        System.out.println("x509Certificate_getNotBefore_证书有效期___:"+x509Certificate.getNotAfter());
        System.out.println("x509Certificate_getSigAlgName_签名算法___:"+x509Certificate.getSigAlgName());
        System.out.println("x509Certificate_getVersion_版本号___:"+x509Certificate.getVersion());
        System.out.println("x509Certificate_getPublicKey_公钥___:"+x509Certificate.getPublicKey());
        return x509Certificate;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "server.cer";
        new CertUtil().getX509CerCate(new CertUtil().repoPath+fileName);
        //new CertUtil().genCertificate("123");

        //new CertUtil().baseToASCII(new CertUtil().repoPath+fileName);
    }
}
