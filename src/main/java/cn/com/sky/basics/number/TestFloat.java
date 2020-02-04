package cn.com.sky.basics.number;

import org.junit.Test;

public class TestFloat {

    @Test
    public void test2() {
        float a = 0.00f;
        System.out.println(a == 0);
        Float b = new Float(0.0);
        System.out.println(b == 0);
        System.out.println(b > 0);
        System.out.println(a == b);
    }

    @Test
    public void test1() {
        float a = 2.4f;
        //数据不准确，输出：240.00002
        System.out.println(a * 100);
    }

    @Test
    public void tesf() {
        System.out.println(0.3 - 0.2);
    }
}
