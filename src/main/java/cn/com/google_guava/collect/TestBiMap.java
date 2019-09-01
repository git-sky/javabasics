package cn.com.google_guava.collect;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 *
 * BiMap提供了一种新的集合类型，它提供了key和value的双向关联的数据结构。
 *
 * BiMap的实现类
 *
 * 　　Key-Value Map Impl     Value-Key Map Impl     Corresponding BiMap
 * 　　HashMap                 　　  HashMap                       HashBiMap
 * 　　ImmutableMap           　　ImmutableMap               ImmutableBiMap
 * 　　EnumMap                　　  EnumMap                      EnumBiMap
 * 　　EnumMap                 　　 HashMap                       EnumHashBiMap
 *
 * </pre>
 */
public class TestBiMap {

    @Test
    public void testInverseMap() {
        Map<Integer, String> logfileMap = Maps.newHashMap();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");

        System.out.println("logfileMap:" + logfileMap);

        Map<String, Integer> logfileInverseMap = Maps.newHashMap();

        logfileInverseMap = getInverseMap(logfileMap);

        System.out.println("logfileInverseMap:" + logfileInverseMap);
    }

    /**
     * 逆转Map的key和value
     *
     * @param <S>
     * @param <T>
     * @param map
     * @return
     */
    private static <S, T> Map<T, S> getInverseMap(Map<S, T> map) {
        Map<T, S> inverseMap = new HashMap<T, S>();
        for (Map.Entry<S, T> entry : map.entrySet()) {
            inverseMap.put(entry.getValue(), entry.getKey());
        }
        return inverseMap;
    }


    @Test
    public void testInverseMapByBiMap() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);

        System.out.println("logfileMap:" + logfileMap);
    }

    /**
     * 在使用BiMap时，会要求Value的唯一性。如果value重复了则会抛出错误：java.lang.IllegalArgumentException，例如：
     */
    @Test
    public void TestBimap2() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        logfileMap.put(4, "d.log");
        logfileMap.put(5, "d.log");
    }


    @Test
    public void TestBimap3() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");

        logfileMap.put(4, "d.log");
        //如果我们确实需要插入重复的value值，那可以选择forcePut方法。但是我们需要注意的是前面的key也会被覆盖了。
        logfileMap.forcePut(5, "d.log");
        System.out.println("logfileMap:" + logfileMap);
    }


    /**
     * inverse方法会返回一个反转的BiMap，但是注意这个反转的map不是新的map对象，它实现了一种视图关联，这样你对于反转后的map的所有操作都会影响原先的map对象。例如：
     */
    @Test
    public void BimapTest() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);

        logfileMap.put(4, "d.log");

        System.out.println("logfileMap:" + logfileMap);
        System.out.println("filelogMap:" + filelogMap);
    }

}