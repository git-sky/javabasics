package cn.com.sky.rate_limit.limiter_algorithm;

/**
 * 令牌桶算法(流入恒定，流出不恒定。)
 *
 * 个人理解：令牌的流入代表下游的处理能力，令牌桶的流出代表上游的请求，令牌桶的容量代表可以同时处理的最大请求数量。
 */
public class TokenBucketDemo {
    public long timeStamp = System.currentTimeMillis();
    public int capacity = 100; // 桶的容量
    public int rate = 1; // 令牌放入速度(1000/s)
    public int tokens = 100; // 当前令牌数量

    public boolean grant() {
        long now = System.currentTimeMillis();
        // 先添加令牌
        tokens = (int) Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;
        if (tokens < 1) {
            // 若不到1个令牌,则拒绝
            return false;
        } else {
            // 还有令牌，领取令牌
            tokens -= 1;
            return true;
        }
    }
}