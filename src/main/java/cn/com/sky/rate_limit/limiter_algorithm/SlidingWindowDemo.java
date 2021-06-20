package cn.com.sky.rate_limit.limiter_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动时间窗口算法（Sliding Window）
 */
public class SlidingWindowDemo {
    private final int limit = 100; // 时间窗口内最大请求数
    private final long interval = 1000; // 时间窗口 1000 ms, 1s

    private List<Long> reqTimes = new ArrayList() {{
        add(System.currentTimeMillis());
    }}; // 记录请求的时间

    public boolean grant() {
        long t_m = System.currentTimeMillis();
        if (reqTimes.size() > 0) {
            // 判断 t_m 是否在时间窗口内
            if (t_m < reqTimes.get(0) + interval) {
                // 判断当前时间窗口内是否超过最大请求控制数
                if (reqTimes.size() < limit) {
                    reqTimes.add(t_m);
                    return true;
                } else {
                    return false;
                }
            } else {
                // 如果不在时间窗口内，丢弃第一个时间点
                reqTimes.remove(0);
                return true;
            }
        } else {
            reqTimes.add(t_m);
            return true;
        }
    }
}