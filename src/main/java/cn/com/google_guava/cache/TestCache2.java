package cn.com.google_guava.cache;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class TestCache2 {

    @Test
    public void testCache() throws Exception {
        LoadingCache<String, String> commonCache = commonCache("peida");
        System.out.println("peida:" + commonCache.get("peida"));
        System.out.println("harry:" + commonCache.get("harry"));
        System.out.println("lisa:" + commonCache.get("lisa"));
    }

    private LoadingCache<String, String> commonCache(final String key) throws Exception {
        LoadingCache<String, String> commonCache = cached(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        });
        return commonCache;
    }


    /**
     * 不需要延迟处理(泛型的方式封装)
     **/
    private <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
        LoadingCache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(2)
                .weakKeys()
                .softValues()
                .refreshAfterWrite(120, TimeUnit.SECONDS)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<K, V>() {
                    @Override
                    public void onRemoval(RemovalNotification<K, V> rn) {
                        System.out.println(rn.getKey() + "被移除");

                    }
                })
                .build(cacheLoader);
        return cache;
    }


    private static Cache<String, String> cacheFormCallable = null;


    @Test
    public void testCallableCache() throws Exception {
        final String u1name = "peida";
        final String u2name = "jerry";
        final String u3name = "lisa";
        cacheFormCallable = callableCached();
        System.out.println("peida:" + getCallableCache(u1name));
        System.out.println("jerry:" + getCallableCache(u2name));
        System.out.println("lisa:" + getCallableCache(u3name));
        System.out.println("peida:" + getCallableCache(u1name));
    }

    /**
     * 对需要延迟处理的可以采用这个机制；(泛型的方式封装)
     */
    public static <K, V> Cache<K, V> callableCached() throws Exception {
        Cache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
        return cache;
    }


    private String getCallableCache(final String userName) {
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cacheFormCallable.get(userName, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(userName + " from db");
                    return "hello " + userName + "!";
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

}