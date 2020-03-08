package cn.com.sky.encrypt.utils;


import java.io.UnsupportedEncodingException;


public class BytesUtil {

    private final static String STRING_ENCODING = "UTF8";

    private BytesUtil() {
    }

    /**
     * byte array to Hexadecimal string
     *
     * @param bytes byte array
     * @return Hexadecimal string
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", (b & 0xFF)));
        }

        return buf.toString();
    }

    /**
     * Hexadecimal string to byte array
     *
     * @param hexString Hexadecimal string
     * @return byte array
     */
    public static byte[] hexToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16);
        }
        return bytes;
    }

    /**
     * <p>combineBytes.</p>
     *
     * @param front an array of {@link byte} objects.
     * @param rear  an array of {@link byte} objects.
     * @return an array of {@link byte} objects.
     */
    public static byte[] combineBytes(byte[] front, byte[] rear) {
        byte[] result = new byte[front.length + rear.length];
        for (int i = 0; i < result.length; i++) {
            if (i < front.length) {
                result[i] = front[i];
            } else {
                result[i] = rear[i - front.length];
            }
        }
        return result;
    }

    /**
     * <p>getStrBytes.</p>
     *
     * @param s a {@link String} object.
     * @return an array of {@link byte} objects.
     */
    public static byte[] getStrBytes(String s) {
        if (s == null) {
            throw new NullPointerException("param string should not be null");
        }
        try {
            return s.getBytes(STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("should not be here", e);
        }
    }

    /**
     * <p>fromBytesToStr.</p>
     *
     * @param bytes an array of {@link byte} objects.
     * @return a {@link String} object.
     */
    public static String fromBytesToStr(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("param bytes should not be null");
        }
        try {
            return new String(bytes, STRING_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("should not be here", e);
        }
    }
}
