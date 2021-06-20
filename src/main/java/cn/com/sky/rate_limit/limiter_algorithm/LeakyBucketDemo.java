package cn.com.sky.rate_limit.limiter_algorithm;

/**
 * 漏桶算法（流入不恒定，流出恒定。）
 * <p>
 * 个人理解：漏桶的流入代表上游的请求，漏桶的流出代表下游的处理，漏桶的容量代表请求队列大小。
 */
public class LeakyBucketDemo {
    public long timeStamp = System.currentTimeMillis();
    public int capacity = 100; // 桶的容量
    public int rate = 1; // 水漏出的速度(1000/s)
    public int water = 0; // 当前水量(当前累积请求数)

    public boolean grant() {
        long now = System.currentTimeMillis();
        water = (int) Math.max(0, water - (now - timeStamp) * rate); // 先执行漏水，计算剩余水量
        timeStamp = now;
        if ((water + 1) < capacity) {
            // 尝试加水,并且水还未满
            water += 1;
            return true;
        } else {
            // 水满，拒绝加水
            return false;
        }
    }
}