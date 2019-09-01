package cn.com.sky.basics;

import java.util.Arrays;

public class TestFinal {

    private static final String a = "abc";

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(TestFinal.a);
        String[] arr = {};
        System.out.println(Arrays.toString(arr));

//        a="aaa";
    }

}
