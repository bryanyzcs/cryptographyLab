package ecommerce.security;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class Rsa {

    private PublicKey publicKey;
    private PrivateKey privateKey;


    public String base64Encode(byte[] data) {
        return new BASE64Encoder().encode(data);
    }

    public byte[] base64Decode(String data) throws IOException {
        return new BASE64Decoder().decodeBuffer(data);
    }

    public void loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = base64Decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = base64Decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
    public byte[] decrypt(byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encrypted);
    }
    public byte[] encrypt(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }
}
