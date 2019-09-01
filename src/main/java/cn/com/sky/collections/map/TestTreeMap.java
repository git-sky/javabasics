package cn.com.sky.collections.map;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * <pre>
 *
 * TreeMap根据元素的key进行排序， 可以通过两种方式确定排序算法：
 * 1.TreeMap构造方法加入Comparator
 * 2.使用一个实现了 Comparable 接口的key
 *
 * String实现了 Comparable 接口,默认按照key的自然顺序排序.
 *
 * </pre>
 */
public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap<>();
        for (int i = 10; i > 0; i--) {
            String a = "key" + i;
            String b = "value" + i;
            tm.put(a, b);
        }

        // 第一种方法
        // 使用entrySet()方法生成一个由Map.entry对象组成的Set,
        // 而Map.entry对象包括了每个元素的"键"和"值".这样就可以用iterator了
        Iterator<Entry<String, String>> it = tm.entrySet().iterator();
        while (it.hasNext()) {
            // entry的输出结果如key0=value0等
            Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(entry);
            System.out.println(key);
            System.out.println(value);
        }

        System.out.println("=====================================");

        // 第二种方法
        // 这是用TreeMap的keySet()方法，生成的对象是由key对象组成的Set
        // 再利用TreeMap的get(key)方法，得到对应的value值
        Iterator<String> ite = tm.keySet().iterator();
        while (ite.hasNext()) {
            // ite.next()得到的是key，tm.get(key)得到obj
            System.out.println(tm.get(ite.next()));
        }

        System.out.println("------SortedMap子类的方法------------");
        System.out.println(tm.firstKey());// map中最小元素
        System.out.println(tm.lastKey());// map中最大元素
    }
}