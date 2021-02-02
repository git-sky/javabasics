package cn.com.sky.basics.test_random;


import java.util.concurrent.ThreadLocalRandom;

/**
 * 如果ThreadLocalRandom.current()定义为成员变量，在多线程下产生相同随机数。
 * 所以在多线程下使用 ThreadLocalRandom 产生随机数时，应该直接使用 ThreadLocalRandom.current().xxxx 。见"ThreadLocalRandomDemoRight"
 */
public class ThreadLocalRandomDemoWrong {

    private static final ThreadLocalRandom RANDOM =
            ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Player().start();
        }
    }

    private static class Player extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + ": " + RANDOM.nextInt(100));
        }
    }
}