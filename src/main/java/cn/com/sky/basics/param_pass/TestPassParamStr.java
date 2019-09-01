package cn.com.sky.basics.param_pass;

/**
 * 值传递（String类型是不可变类型，s指向新的内存空间。）
 */
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
