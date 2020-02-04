package cn.com.sky.collections.list;

import java.util.*;

/**
 * <pre>
 *
 * 向队列头部添加对象，ArrayList 和 LinkedList 的效率比较。
 *
 * ArrayList会数组拷贝，性能很低
 *
 * LinkedList只是创建节点,性能比较高
 *
 * ArrayList耗时：20069
 * LinkedList耗时：20
 */
public class TestListEfficiencyAdd {
    static final int N = 500000;

    static long timeList(List<Object> list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++)
            list.add(0, o);
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList耗时：" + timeList(new ArrayList<Object>()));
        System.out.println("LinkedList耗时：" + timeList(new LinkedList<Object>()));
    }
}
