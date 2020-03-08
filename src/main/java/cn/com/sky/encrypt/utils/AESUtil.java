package cn.com.sky.encrypt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;


public class AESUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);


    /**
     * The constant that denotes the algorithm being used.
     */
    private static final String algorithm = "AES";
    /**
     * Constant <code>AES_KEY_LENGTH_BIT=128</code>
     */
    public static final int AES_KEY_LENGTH_BIT = 128;

    /**
     * The private constructor to prevent instantiation of this object.
     */
    private AESUtil() {

    }

    /**
     * The method that will generate a random {@link SecretKey}.
     *
     * @return The key generated.
     */
    public static SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            keyGenerator.init(AES_KEY_LENGTH_BIT);
            return keyGenerator.generateKey();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Creates a new {@link SecretKey} based on a password.
     *
     * @param password The password that will be the {@link SecretKey}.
     * @return The key.
     */
    public static SecretKey createKey(String password) {
        try {
            byte[] key = password.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, AES_KEY_LENGTH_BIT / 8); // use only first 128 bit

            return new SecretKeySpec(key, algorithm);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Creates a new {@link SecretKey} based on a password with a specified salt.
     *
     * @param salt     The random salt.
     * @param password The password that will be the {@link SecretKey}.
     * @return The key.
     */
    public static SecretKey createKey(byte[] salt, String password) {
        try {
            byte[] key = (salt + password).getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, AES_KEY_LENGTH_BIT / 8); // use only first 128 bit

            return new SecretKeySpec(key, algorithm);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * The method that writes the {@link SecretKey} to a file.
     *
     * @param key  The key to write.
     * @param file The file to create.
     * @throws IOException if any.
     */
    public static void writeKey(SecretKey key, File file) throws IOException {
        try (FileOutputStream fis = new FileOutputStream(file)) {
            fis.write(key.getEncoded());
        }
    }

    /**
     * Gets a {@link SecretKey} from a {@link File}.
     *
     * @param file The file that is encoded as a key.
     * @return The key.
     * @throws IOException if any.
     */
    public static SecretKey getSecretKey(File file) throws IOException {
        return new SecretKeySpec(Files.readAllBytes(file.toPath()), algorithm);
    }

    /**
     * The method that will compute data.
     *
     * @param secretKey The key used to compute the data.
     * @param data      The data to compute.
     * @return The encrypted data.
     */
    public static byte[] encrypt(SecretKey secretKey, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * The method that will decrypt a piece of encrypted data.
     *
     * @param password  The password used to decrypt the data.
     * @param encrypted The encrypted data.
     * @return The decrypted data.
     */
    public static byte[] decrypt(String password, byte[] encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, AESUtil.createKey(password));
            return cipher.doFinal(encrypted);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * The method that will decrypt a piece of encrypted data.
     *
     * @param secretKey The key used to decrypt encrypted data.
     * @param encrypted The encrypted data.
     * @return The decrypted data.
     */
    public static byte[] decrypt(SecretKey secretKey, byte[] encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encrypted);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    // 获取AES加密的实例对象
    private static SecretKeySpec a_AES_SecretKeySpec(String strKey) {
        byte[] btArray = null;
        int n_16 = 0x10;
        if (strKey == null) {
            strKey = "";
        }

        StringBuffer sbb = new StringBuffer(n_16);
        sbb.append(strKey);
        while (sbb.length() < n_16) {
            sbb.append("0");
        }

        if (sbb.length() > n_16) {
            sbb.setLength(n_16);
        }

        try {
            btArray = sbb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException v1_1) {
            LOGGER.warn("a_AES_SecretKeySpec E", v1_1);
            btArray = null;
        }

        return new SecretKeySpec(btArray, "AES");
    }

    // 使用AES加密数据

    /**
     * <p>a_AES_Encryption.</p>
     *
     * @param arg4   an array of {@link byte} objects.
     * @param strKey a {@link String} object.
     * @param strIv  a {@link String} object.
     * @return an array of {@link byte} objects.
     */
    public static byte[] a_AES_Encryption(byte[] arg4, String strKey, String strIv) {
        byte[] v0_2;
        try {
            SecretKeySpec secretKeySpec = AESUtil.a_AES_SecretKeySpec(strKey);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, ((Key) secretKeySpec), AESUtil.b_IvParameterSpec(strIv));
            v0_2 = cipher.doFinal(arg4);
        } catch (Exception exp) {
            LOGGER.warn("a_AES_Encryption E", exp);
            v0_2 = null;
        }

        return v0_2;
    }

    // AES解密服务器返回的数据

    /**
     * <p>b_AES_Decryption.</p>
     *
     * @param btRetData     an array of {@link byte} objects.
     * @param strKey        a {@link String} object.
     * @param str_signature a {@link String} object.
     * @return an array of {@link byte} objects.
     */
    public static byte[] b_AES_Decryption(byte[] btRetData, String strKey, String str_signature) {

        byte[] v0_2;
        try {
            // 获取AES加密的实例对象
            SecretKeySpec secretKeySpec = AESUtil.a_AES_SecretKeySpec(strKey);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // 进行数据的AES解密
            cipher.init(2, ((Key) secretKeySpec), AESUtil.b_IvParameterSpec(str_signature));
            v0_2 = cipher.doFinal(btRetData);

        } catch (Exception exp) {
            LOGGER.warn("b_AES_Decryption e", exp);
            v0_2 = null;
        }

        return v0_2;
    }

    // 获取AES的加密向量
    private static IvParameterSpec b_IvParameterSpec(String strIvParam) {

        byte[] btArray = null;
        int n_16 = 0x10;

        if (strIvParam == null) {

            strIvParam = "";
        }

        StringBuffer sbb = new StringBuffer(n_16);
        sbb.append(strIvParam);
        while (sbb.length() < n_16) {

            sbb.append("0");
        }

        if (sbb.length() > n_16) {

            sbb.setLength(n_16);
        }

        try {
            btArray = sbb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException exp) {
            LOGGER.warn("b_IvParameterSpec e", exp);
            btArray = null;
        }

        return new IvParameterSpec(btArray);
    }
}


