package certification.certificate;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignAlgorithm {

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

    public String sign(String privateKey,String content,String publicKey) {
        Rsa rsa = new Rsa();
        byte[] bytes;
        String returnvalue = null;
        try {
            rsa.loadPrivateKey(privateKey);
            rsa.loadPublicKey(publicKey);
            //Hash
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(content.getBytes());
            bytes = messageDigest.digest();
            //encode, encrypt
            byte[] encrypt = rsa.encrypt(rsa.base64Encode(bytes));
            //encrypt
            returnvalue = rsa.base64Encode(encrypt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnvalue;

    }


}
