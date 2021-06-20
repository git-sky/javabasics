package cn.com.sky.basics.regular_expression;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配
 */
public class TestRegex {


    @Test
    public void test1() {
//        String s="www.baidu.com";
//        System.out.println(s.matches("w"));

        System.out.println(isRegex("\"2ad22ac6cd7c4197898ed9b10896f917\""));
    }


    public static void main(String[] args) {
        System.out.println(isRegex2("中[国]htt_(api)_【v¥3】_2【【【山】】】（（（（山））））（水水）0()[]"));

        String telRegex = "^(1)\\d{10}$";
        System.out.println("18234567901".matches(telRegex));


        System.out.println("a*b".contains("*"));


    }


    public static boolean isRegex(String str) {
        //英文，数字
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    public static boolean isRegex2(String str) {
        //中英文，数字，中英文中括号，中英文小括号
        String regex = "[\u4e00-\u9fa5_a-zA-Z0-9_\\(\\)\\[\\]（）【】]{1,500}";
        return str.matches(regex);
    }


    public static String match(String name) {
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5_a-zA-Z0-9_]{1,30}");

        Matcher m = p.matcher(name);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            System.out.println(m.group());
        }

        return "";
    }
}