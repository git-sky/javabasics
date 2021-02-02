package cn.com.a_temp;

import org.apache.commons.lang3.RandomUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;


public class Testd {


    public static void main(String[] args) throws UnsupportedEncodingException {


        System.out.println("空格:" + URLEncoder.encode(" ", "UTF8"));
        System.out.println("加号:" + URLEncoder.encode("+", "UTF8"));
        System.out.println("加号:" + URLEncoder.encode("+", "GBK"));

        System.out.println("星号:" + URLEncoder.encode("*", "UTF8"));

        System.out.println("等号:" + URLEncoder.encode("=", "UTF8"));

        System.out.println("空格:" + URLEncoder.encode("%2B", "UTF8"));

        System.out.println(System.currentTimeMillis());


        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
//        f08ff5d1c11c485ebd017da1bd4e9861
//        96281143a58a414389dc1cb1cb7f638b

        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.nextInt(1000, 9999));
        }
    }


}