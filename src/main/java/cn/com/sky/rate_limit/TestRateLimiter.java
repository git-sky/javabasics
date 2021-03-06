package cn.com.sky.rate_limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Google开源工具包Guava提供了限流工具类RateLimiter,该类基于令牌桶算法(Token
 * Bucket)来完成限流,非常易于使用.RateLimiter经常用于限制对一些物理资源或者逻辑资源的访问速率
 * .它支持两种获取permits接口,一种是如果拿不到立刻返回false,一种会阻塞等待一段时间看能不能拿到.
 *
 * https://www.cnblogs.com/xuwc/p/9123078.html
 */
public class TestRateLimiter {

    public static void main(String[] args) {
        RateLimiter rl = RateLimiter.create(10);

    }
}
