package cn.com.sky.collections.map.hashmap_demo;

import org.junit.Test;

import java.util.HashMap;

/**
 * <pre>
 *
 * hashmap.computeIfAbsent(K key, Function remappingFunction)
 *
 * computeIfAbsent() 方法。
 * 如果不存在这个key，对 hashMap 中指定 key 的值进行计算，并添加到 hasMap 中。
 * 如果存在这个key，则不计算，返回原来的值。
 *
 * </pre>
 */
public class Test_computeIfAbsent {

    @Test
    public void test1() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);


    }

    @Test
    public void test2() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射关系
        prices.put("Shoes", 180);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // Shoes中的映射关系已经存在
        // Shoes并没有计算新值
        int shoePrice = prices.computeIfAbsent("Shoes", (key) -> 280);
        System.out.println("Price of Shoes: " + shoePrice);

        // 输出更新后的 HashMap
        System.out.println("Updated HashMap: " + prices);
    }


}