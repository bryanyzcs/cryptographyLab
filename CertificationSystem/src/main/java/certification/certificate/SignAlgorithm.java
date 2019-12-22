package certification.certificate;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;

public class SignAlgorithm {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    public String getKey(String path){
        File file = new File(path);
        StringBuffer pk = new StringBuffer();
        String returnvalue = null;
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = inputStream.readLine())!=null){
                if(!line.contains("KEY")){
                    pk.append(line);
                }
            }
            System.out.println(pk);
            returnvalue = pk.toString();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnvalue;
    }

//    public String sign(String privateKey,String content,String publicKey) {
//        Rsa rsa = new Rsa();
//        String returnvalue = null;
//        byte[] bytes;
//        try {
//            rsa.loadPrivateKey(privateKey);
//            //rsa.loadPublicKey(publicKey);
//            //Hash
//            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
////            messageDigest.update(content.getBytes());
////            MessageDigest tc1 = (MessageDigest) messageDigest.clone();
////            byte[] toChapter1Digest = tc1.digest();
////            //messageDigest.update(content.getBytes());
//            bytes = messageDigest.digest(content.getBytes());
////            MessageDigest md = MessageDigest.getInstance("SHA1");
////            md.update(content.getBytes());
////            byte[] bits = md.digest();
//            //bytes = org.apache.catalina.realm.RealmBase.Digest(content,"sha-1","utf-8");
//            //encode, encrypt
//            //System.out.println("hash=======>  "+rsa.base64Encode(bytes));
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0; i < bytes.length; i++) {
//                String hex = Integer.toHexString(bytes[i] & 0xFF);
//                if(hex.length() < 2){
//                    sb.append(0);
//                }
//                sb.append(hex);
//            }
//            System.out.println(sb.toString());
//
//            byte[] encrypt = rsa.encrypt(sb.toString().getBytes());
//            sb = new StringBuffer();
//            for(int i = 0; i < encrypt.length; i++) {
//                String hex = Integer.toHexString(encrypt[i] & 0xFF);
//                if(hex.length() < 2){
//                    sb.append(0);
//                }
//                sb.append(hex);
//            }
//            System.out.println(sb.toString());
//            //encrypt
//            returnvalue = rsa.base64Encode(sb.toString().getBytes());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return returnvalue;
//
//    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String signNew(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    public static byte[] decryptBASE64(String key) {
        return Base64.decodeBase64(key);
    }

    public static String encryptBASE64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }


    public String sign(String privateKey,String content,String publicKey) {
        Rsa rsa = new Rsa();
        String returnvalue = null;
        byte[] bytes;
        try {
            rsa.loadPrivateKey(privateKey);
            //rsa.loadPublicKey(publicKey);
            //Hash
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
//            messageDigest.update(content.getBytes());
//            MessageDigest tc1 = (MessageDigest) messageDigest.clone();
//            byte[] toChapter1Digest = tc1.digest();
//            //messageDigest.update(content.getBytes());
            bytes = messageDigest.digest(content.getBytes());
//            MessageDigest md = MessageDigest.getInstance("SHA1");
//            md.update(content.getBytes());
//            byte[] bits = md.digest();
            //bytes = org.apache.catalina.realm.RealmBase.Digest(content,"sha-1","utf-8");
            //encode, encrypt
            //System.out.println("hash=======>  "+rsa.base64Encode(bytes));
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if(hex.length() < 2){
                    sb.append(0);
                }
                sb.append(hex);
            }
            System.out.println(sb.toString());

            byte[] encrypt = rsa.encrypt(sb.toString().getBytes());
            sb = new StringBuffer();
            for(int i = 0; i < encrypt.length; i++) {
                String hex = Integer.toHexString(encrypt[i] & 0xFF);
                if(hex.length() < 2){
                    sb.append(0);
                }
                sb.append(hex);
            }
            System.out.println(sb.toString());
            //encrypt
            returnvalue = rsa.base64Encode(sb.toString().getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnvalue;

    }


}
