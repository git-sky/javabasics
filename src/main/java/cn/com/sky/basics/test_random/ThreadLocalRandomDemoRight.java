package cn.com.sky.basics.test_random;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemoRight {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Player().start();
        }
    }

    private static class Player extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + ": " + ThreadLocalRandom.current().nextInt(100));
        }
    }
}