package cn.com.sky.encrypt.utils;


import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAUtil {

    /**
     * The constant that denotes the algorithm being used.
     */
    private static final String algorithm = "RSA";
    private static final String algorithm2 = "SHA256WithRSA";
    /**
     * Constant <code>RSA_KEYSIZE=512</code>
     */
    public static final int RSA_KEYSIZE = 512;

    /**
     * The private constructor to prevent instantiation of this object.
     */
    private RSAUtil() {

    }

    /**
     * The method that will create both the public and private key used to compute and decrypt the data.
     *
     * @param publicKeyOutputPath  The path of where the public key will be created.
     * @param privateKeyOutputPath The path of where the private key will be created.
     * @return {@code true} If this operation was successful, otherwise {@code false}.
     * @throws IOException if any.
     */
    public static boolean generateKeyToFile(String publicKeyOutputPath, String privateKeyOutputPath) throws IOException {
        OutputStream pubOutputStream = null;
        OutputStream priOutputStream = null;
        try {
            File pubFile = createFile(publicKeyOutputPath);
            File priFile = createFile(privateKeyOutputPath);
            pubOutputStream = new DataOutputStream(new FileOutputStream(pubFile));
            priOutputStream = new DataOutputStream(new FileOutputStream(priFile));
            return generateKey(pubOutputStream, priOutputStream);
        } finally {
            if (priOutputStream != null) {
                priOutputStream.flush();//NOSONAR
                priOutputStream.close();
            }
            if (pubOutputStream != null) {
                pubOutputStream.flush();
                pubOutputStream.close();
            }
        }
    }

    private static File createFile(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        if (!f.createNewFile()) {
            if (f.delete()) {
                f.createNewFile();
            }
        }
        return f;
    }

    /**
     * <p>generateKey.</p>
     *
     * @param publicKeyOutput  a {@link OutputStream} object.
     * @param privateKeyOutput a {@link OutputStream} object.
     * @return a boolean.
     * @throws IOException if any.
     */
    public static boolean generateKey(OutputStream publicKeyOutput, OutputStream privateKeyOutput) throws IOException {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
            keyGen.initialize(RSA_KEYSIZE);

            final KeyPair key = keyGen.generateKeyPair();

            publicKeyOutput.write(key.getPublic().getEncoded());
            publicKeyOutput.flush();

            privateKeyOutput.write(key.getPrivate().getEncoded());
            privateKeyOutput.flush();

            return true;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The method that will compute an array of bytes.
     *
     * @param key  The public key used to compute the data.
     * @param data The data in the form of bytes.
     * @return The encrypted bytes, otherwise {@code null} if crypto could not be performed.
     */
    public static byte[] encrypt(Key key, byte[] data) {
        return encrypt(key, data, algorithm);
    }

    public static byte[] encrypt(Key key, byte[] data, String algorithm) {
        try {

            final Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.ENCRYPT_MODE, key);

            return cipher.doFinal(data);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static byte[] signature(byte[] plainText, PrivateKey privateKey, String signAlgor) {
        if (signAlgor == null || signAlgor.equals("")) {
            signAlgor = algorithm2;
        }
        try {
            Signature signature = Signature.getInstance(signAlgor);
            signature.initSign(privateKey);
            signature.update(plainText);
            return signature.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean signVerified(byte[] plainText, byte[] signData, PublicKey publicKey, String signAlgor) {
        try {
            Signature signature = Signature.getInstance(signAlgor);
            signature.initVerify(publicKey);
            signature.update(plainText);
            return signature.verify(signData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The method that will decrypt an array of bytes.
     *
     * @param key           The {@link PrivateKey} used to decrypt the data.
     * @param encryptedData The encrypted byte array.
     * @return The decrypted data, otherwise {@code null} if decryption could not be performed.
     */
    public static byte[] decrypt(Key key, byte[] encryptedData) {

        try {

            final Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.DECRYPT_MODE, key);

            return cipher.doFinal(encryptedData);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * The method that will re-create a {@link PublicKey} from a serialized key.
     *
     * @param publicKeyPath The path of the public key file.
     * @return The {@link PublicKey} object.
     * @throws IOException if any.
     */
    public static PublicKey getPublicKey(String publicKeyPath) throws IOException {
        try {
            return KeyFactory.getInstance(algorithm).generatePublic(new X509EncodedKeySpec(Files.readAllBytes(Paths.get(publicKeyPath))));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new IOException(e);
        }
    }

    /**
     * The method that will re-create a {@link PrivateKey} from a serialized key.
     *
     * @param privateKeyPath The path of the private key file.
     * @return The {@link PrivateKey} object.
     * @throws Exception if any.
     */
    public static PrivateKey getPrivateKey(String privateKeyPath) throws Exception {
        return KeyFactory.getInstance(algorithm).generatePrivate(new PKCS8EncodedKeySpec(Files.readAllBytes(Paths.get(privateKeyPath))));
    }

    /**
     * The method that will re-create a {@link PublicKey} from a public key byte array.
     *
     * @param encryptedPublicKey The byte array of a public key.
     * @return The {@link PublicKey} object.
     */
    public static PublicKey getPublicKey(byte[] encryptedPublicKey) {
        try {
            return KeyFactory.getInstance(algorithm).generatePublic(new X509EncodedKeySpec(encryptedPublicKey));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * The method that will re-create a {@link PrivateKey} from a private key byte array.
     *
     * @param encryptedPrivateKey The array of bytes of a private key.
     * @return The {@link PrivateKey} object.
     */
    public static PrivateKey getPrivateKey(byte[] encryptedPrivateKey) {
        try {
            return KeyFactory.getInstance(algorithm).generatePrivate(new PKCS8EncodedKeySpec(encryptedPrivateKey));
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static PublicKey getPubKeyByModulus(byte[] modulus, byte[] exponent, String algorithm) {
        BigInteger m = new BigInteger(1, modulus);
        BigInteger e = new BigInteger(1, exponent);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        try {
            return KeyFactory.getInstance(algorithm).generatePublic(keySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e1) {
            throw new RuntimeException(e1);
        }
    }

    public static PublicKey getPubKeyByModulus(String modulus, String exponent, String algorithm) {
        BigInteger m = new BigInteger(modulus, 16);
        BigInteger e = new BigInteger(exponent, 16);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        try {
            return KeyFactory.getInstance(algorithm).generatePublic(keySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e1) {
            throw new RuntimeException(e1);
        }
    }

    /**
     * 装载公钥
     *
     * @param modulus
     * @param exponent
     * @param radix    10 或则 16进制
     * @return
     * @throws Exception
     */
    public static RSAPublicKey loadPublicKey(String modulus, String exponent, int radix) throws Exception {
        BigInteger mod = new BigInteger(modulus, radix);
        BigInteger exp = new BigInteger(exponent, radix);
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(mod, exp);
        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
    }
}




