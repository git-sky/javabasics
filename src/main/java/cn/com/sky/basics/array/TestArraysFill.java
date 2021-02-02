package cn.com.sky.basics.array;


import org.junit.Test;

import java.util.Arrays;

/**
 * Arrays.fill(a1, value);
 * 填充a1数组中的每个元素都是value
 */
public class TestArraysFill {

    @Test
    public void test1() {
        boolean[] a1 = new boolean[5];
        Arrays.fill(a1, true);

        System.out.println(Arrays.toString(a1));

        //a1[] = {true,true,true,true,true};
    }


    @Test
    public void test2() {
        String[] a9 = new String[6];

        Arrays.fill(a9, "Hello");
        System.out.println(Arrays.toString(a9));

        Arrays.fill(a9, 3, 5, "xxx");
        System.out.println(Arrays.toString(a9));

        //a9[] = {Hello,Hello,Hello,World,World,Hello};
    }

    @Test
    public void test3() {
        final byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        System.out.println(iv);
        System.out.println(Arrays.toString(iv));

    }
}