package cn.com.sky.basics;

import org.junit.Test;

/**
 * return直接方法返回，可以退出多层循环。循环之后的也不会执行。
 */
public class TestReturn {

    public static void main(String args[]) {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (j == 10) {
                    return;
                }
                System.out.println("i=" + i + ",j=" + j);
            }

        }

        System.out.println("hhhhhhhhhhhhhhhhhh");
    }

    @Test
    public void get() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {

                    System.out.println("i=" + i + ",j=" + j + ",k=" + k);
                    if (k == 3) {
                        return;
                    }
                }
            }
        }

        System.out.println("ggggggggg");


    }

}
