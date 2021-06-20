package cn.com.sky.basics.exceptions;

import org.junit.Test;

/**
 *
 */
public class TestThrow {

    @Test
    public void test() {
        try {
            int c = 100 / 0;
        } catch (Throwable throwable) {
//            System.out.println("catch....");
            throw throwable;
        } finally {
            System.out.println("finally....");
        }

        System.out.println("fffff");
    }
}