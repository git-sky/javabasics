package cn.com.google_guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class TestCache3 {

    @Test
    public void test() {
        Cache<String, String> nameCache = CacheBuilder.newBuilder()
                .recordStats()
                .expireAfterAccess(1, TimeUnit.HOURS)
                .maximumSize(100000)
                .build();

        nameCache.put("abc", "empty");

        String resultVal = nameCache.getIfPresent("abc");
        System.out.println(resultVal);

        nameCache.invalidate("abc");

        nameCache.invalidateAll();

        resultVal = nameCache.getIfPresent("abc");
        System.out.println(resultVal);

        CacheStats stats = nameCache.stats();
        System.out.println(stats.toString());
    }


    Cache<Integer, String> cityCountryEmptyCache = CacheBuilder.newBuilder()
            .recordStats().expireAfterWrite(20, TimeUnit.SECONDS)
//            .expireAfterAccess(20, TimeUnit.SECONDS)
            .maximumSize(10000)
            .build();

    @Test
    public void testg() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StopWatch stopWatch = new StopWatch();
            stopWatch.start("getValue" + i);
            Integer v = getValue(1);
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println(v);
        }
    }


    private Integer getValue(Integer cityId) {
        if (Objects.equals(cityCountryEmptyCache.getIfPresent(cityId), "empty")) {
            return null;
        }

        System.out.println("+++++++++++++++++*********************++++++++++++++++");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cityCountryEmptyCache.put(cityId, "empty");

        return null;

    }

}