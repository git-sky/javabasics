package cn.com.sky.basics;

import org.junit.Test;

/**
 * 类型转换
 */
public class TestObjectConvert {

    public static void main(String[] args) {
        Object a = "3";
        System.out.println(Integer.valueOf((String) a));
        System.out.println(Integer.parseInt((String) a));
        System.out.println(Integer.parseInt(String.valueOf(a)));

    }

    @Test
    public void test() {
        Object a = "3";
        //类型转换错误
        Integer b = (Integer) a;
        System.out.println(b);

    }

}
