package cn.com.sky.basics.test_random;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class TestRandom2 {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.nextInt());
        }
    }


    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            System.out.println(random.nextInt());
        }
    }
}