package cn.com.sky.rate_limit.limiter_algorithm;

/**
 * 测试限流算法
 */
public class TestLimiter {


    public static void main(String[] args) {

//        CounterDemo demo = new CounterDemo();

        SlidingWindowDemo demo = new SlidingWindowDemo();

//        LeakyBucketDemo demo = new LeakyBucketDemo();

//        TokenBucketDemo demo = new TokenBucketDemo();





        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(demo.grant());
            System.out.println(System.currentTimeMillis());
        }
    }
}