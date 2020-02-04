package cn.com.sky.basics.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码：URLEncoder.encode(String s, String enc)
 * 解码: URLDecoder.decode(String s, String enc)
 */

public class TestEncoder {

    public static void main(String args[]) {

        try {
            String str = URLEncoder.encode("打发士大夫dfas33ddsd几顿饭", "utf-8");

            System.out.println(str);

            String str2 = URLDecoder.decode(str, "utf-8");

            System.out.println(str2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
