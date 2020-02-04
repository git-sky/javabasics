package cn.com.sky.alpha_work;


import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadStatus {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));//e0000000

    @Test
    public void test() {


        System.out.println(Integer.toHexString(RUNNING));
        System.out.println(Integer.toHexString(SHUTDOWN));
        System.out.println(Integer.toHexString(STOP));
        System.out.println(Integer.toHexString(TIDYING));
        System.out.println(Integer.toHexString(TERMINATED));

        System.out.println("------------------------");

        System.out.println(Integer.toHexString(Integer.SIZE));
        System.out.println(Integer.toHexString(COUNT_BITS));

        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(RUNNING));
        System.out.println(Integer.toHexString(CAPACITY));
        System.out.println(Integer.toHexString(~CAPACITY));


        System.out.println(Integer.toHexString(ctl.get()));


        System.out.println(Integer.toHexString(Integer.MAX_VALUE - 8));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - 8));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 1));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 2));
        System.out.println(Integer.MAX_VALUE + 2);


    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

}
