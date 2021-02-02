package cn.com.sky.tools.iputils;

/**
 * ipv6铺助工具方法-字符串进制转换.
 * Created by sofical on 2020/6/24.
 */
public class Ipv6Helper {
    /**
     * 16进制字符串转为2进制字符串.
     * @param source 16进制源.
     * @return 2进制结果.
     */
    public static String c16To2(String source) {
        Integer h = Integer.valueOf(source, 16);
        String ch = "0000000000000000" + Integer.toBinaryString(h);
        return ch.substring(ch.length() - 16);
    }

    /**
     * 2进制字符串转为16进制字符串.
     * @param source 2进制源.
     * @return 16进制结果.
     */
    public static String c2To16(String source) {
        Integer h = Integer.valueOf(source, 2);
        return Integer.toHexString(h);
    }

    public static void main(String[] args) {
        String i = c16To2("fe80");
        System.out.print(i);
    }
}
