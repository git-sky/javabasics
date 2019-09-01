package cn.com.sky.basics.param_pass;

import org.junit.Test;

/**
 * 值传递（基本类型，不会修改原始值。）
 */
public class TestPassParamPrimitive {

    @Test
    public void testInt() {
        int a = 1;
        int b = 2;
        change(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);


    }

    private void change(int a, int b) {
        System.out.println("befor change a:" + a);
        System.out.println("befor change b:" + b);
        a = 3;
        b = 4;
        a = b;
        System.out.println("after change a:" + a);
        System.out.println("after change b:" + b);
    }


    @Test
    public void testStr() {

        String astr = "a";
        String bstr = "b";

        System.out.println(astr);
        System.out.println(bstr);

        changeStr(astr, bstr);

        System.out.println(astr);
        System.out.println(bstr);

    }

    private static void changeStr(String a, String b) {
        System.out.println("change:" + a);
        System.out.println("change:" + b);
//        a = "aaa";
//        b = "bbb";
//        System.out.println("change:" + a);
//        System.out.println("change:" + b);

        String tmp = a;
        a = b;
        b = tmp;

        System.out.println("change:" + a);
        System.out.println("change:" + b);

    }
}
