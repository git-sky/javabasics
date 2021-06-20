package cn.com.sky.basics.exceptions.demo1;

/**
 *
 */
public class TestExceptionThrow {

    public static void main(String[] args) {

        try {
            test1();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                System.out.println("main i am RuntimeException");
                System.out.println("main " + e);
            }
        }


    }

    public static void test1() {
        try {
            test2();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                System.out.println("test1 i am RuntimeException");
                System.out.println("test1 " + e);
            }
            throw e;
        } finally {
            System.out.println("test1 finally...");
        }
    }

    public static void test2() {
        try {
            test3();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                System.out.println("test2 i am RuntimeException");
                System.out.println("test2 " + e);
            }
            throw e;
        } finally {
            System.out.println("test2 finally...");
        }
    }

    public static void test3() {
        throw new RuntimeException();
    }
}