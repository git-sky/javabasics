package cn.com.google_guava.cache;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


/**
 * 　Guava Cache有两种创建方式：
 * 　　1. cacheLoader
 * 　　2. callable callback
 */
public class TestCache {

    /**
     * CacheLoader的方式实现
     */
    @Test
    public void testLoadingCache() throws Exception {
        LoadingCache<String, String> loadingCache = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue = "hello " + key + "!";
                        return strProValue;
//                        return null;//报错
                    }

                });

        System.out.println("jerry value：" + loadingCache.get("jerry"));
        System.out.println("peida value：" + loadingCache.get("peida"));
        loadingCache.put("harry", "abc");
        System.out.println("harry value：" + loadingCache.get("harry"));

        //不能设置为null，报错
//        loadingCache.put("xyz", null);
//        System.out.println(loadingCache.get("xyz"));

    }


    /**
     * callable callback的方式实现
     **/
    @Test
    public void testCallableCall() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            @Override
            public String call() {
                String strProValue = "hello " + "jerry" + "!";
                return strProValue;
//                return null;//报错
            }
        });
        System.out.println("jerry value : " + resultVal);

        resultVal = cache.get("peida", new Callable<String>() {
            @Override
            public String call() {
                String strProValue = "hello " + "peida" + "!";
                return strProValue;
            }
        });
        System.out.println("peida value : " + resultVal);


//        cache.put("abc", null);//报错
//        System.out.println(cache.getIfPresent("abc"));
    }


}