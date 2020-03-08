package cn.com.sky.encrypt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    private MD5Util() {
    }

    private static final String ALGORITHM = "MD5";

    /**
     * <p>compute.</p>
     *
     * @param data an array of {@link byte} objects.
     * @return a {@link String} object.
     */
    public static String compute(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(data);
            byte[] hash = md.digest();
            return BytesUtil.bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.warn("compute ,e", e);
        }
        return null;
    }
}
