package cn.com.sky.basics.strings;

import java.util.StringTokenizer;

import org.junit.Test;

public class TestSplitStr {

    @Test
    public void testSplitc() {

        String str = "this,is, a,  test,     man";
        String[] result = str.split(",\\s+|,");

        for (int x = 0; x < result.length; x++) {
            System.out.println(result[x]);
        }

    }

    @Test
    public void testSplit() {

        String str = "this is a test";
        String[] result = str.split("\\s");

        for (int x = 0; x < result.length; x++) {
            System.out.println(result[x]);
        }

    }

    /**
     * 推荐使用split或者java.util.regex代替StringTokenizer，StringTokenizer是一个遗留类。
     */
    @Test
    public void testStringToken() {

        // String str = "hello,java,delphi,asp,php";
        // StringTokenizer st = new StringTokenizer(str, ",");
        // while (st.hasMoreTokens()) {
        // System.out.println(st.nextToken());
        // }

        StringTokenizer st = new StringTokenizer("this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

    @Test
    public void testIndexOf() {

    }

}
