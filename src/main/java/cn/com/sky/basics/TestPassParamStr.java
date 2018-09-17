package cn.com.sky.basics;

public class TestPassParamStr {


    public static void main(String[] args) {
        String a = new String("a");
        String b = "b";
        testStr(a, b);
        System.out.println(a);
        System.out.println(b);

    }

    public static void testStr(String a, String b) {
        System.out.println(a);
        System.out.println(b);
        // a="c";
        a = new String("c");
        b = "d";

    }


}
