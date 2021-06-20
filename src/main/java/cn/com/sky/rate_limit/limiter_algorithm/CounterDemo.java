package cn.com.sky.rate_limit.limiter_algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数器限流算法
 */
public class CounterDemo {
    private long timeStamp = System.currentTimeMillis();
    private AtomicInteger reqCount = new AtomicInteger(0);
    private final int limit = 10; // 时间窗口内最大请求数
    private final long interval = 1000; // 时间窗口 1000 ms, 1s

    public boolean grant() {
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount.incrementAndGet();
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount.get() <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount.set(1);
            return true;
        }
    }
}