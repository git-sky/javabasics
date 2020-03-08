package cn.com.sky.encrypt.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

    }

//    public SecretKey genKey() {
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");//密钥生成器
//        keyGen.init(128);  //默认128，获得无政策权限后可为192或256
//        SecretKey secretKey = keyGen.generateKey();//生成密钥
//        return secretKey;
//    }

//    jd() {
//        SecretKey secretKey = new SecretKeySpec(key, "AES");//恢复密钥
//        Cipher cipher = Cipher.getInstance("AES");//Cipher完成加密或解密工作类
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);//对Cipher初始化，解密模式
//        byte[] cipherByte = cipher.doFinal(data);//加密data
//
//    }

}