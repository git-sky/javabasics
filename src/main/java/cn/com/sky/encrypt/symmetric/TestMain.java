package cn.com.sky.encrypt.symmetric;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.RSAUtil;

import javax.crypto.SecretKey;
import java.io.IOException;

public class TestMain {

    private static String getResp(String resp, String seckey) throws IOException {
        SecretKey aesSecKey = AESUtil.createKey(seckey);
//        return new String(AESUtil.decrypt(aesSecKey, resp.getBytes()), "UTF8");

        SecretKey aesKey = AESUtil.generateKey(); //随机生成的128位长度秘钥，用于将请求体加密
        System.out.println(aesKey.getEncoded());
        return new String(aesKey.getEncoded());


//        byte[] bodyEncrypt = AESUtil.encrypt(aesKey, BytesUtil.getStrBytes(requestBodyJson));
//        byte[] tmp1 = RSAUtil.encrypt(RSAUtil.getPrivateKey(priKey), aesKey.getEncoded());
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(getResp("abcabcabcabc", "addddxxxx"));
        String accessToken = "abc";
        byte[] a = AESUtil.encrypt(AESUtil.generateKey(), accessToken.getBytes());
//        System.out.println(new String(a));

//        qZk+NkcGgWq6PiVxeFDCbA==


                SecretKey aesSecKey = AESUtil.createKey("abcd");

        byte[] b = aesSecKey.getEncoded();
        String s = byteToHexString(b);
        System.out.println(s);
        System.out.println("a9993e364706816aba3e25717850c26c");
        System.out.println("十六进制密钥长度为" + s.length());
        System.out.println("二进制密钥的长度为" + s.length() * 4);

    }

    /**
     * byte数组转化为16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex = Integer.toHexString(bytes[i]);
            if (strHex.length() > 3) {
                sb.append(strHex.substring(6));
            } else {
                if (strHex.length() < 2) {
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return sb.toString();
    }


}