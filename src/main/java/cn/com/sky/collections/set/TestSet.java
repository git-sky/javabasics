package cn.com.sky.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * <pre>
 *
 * Set的比较 :
 *
 * HashSet：哈希表是通过使用称为散列法的机制来存储信息的，元素并没有以某种特定顺序来存放；哈希表实现。
 *
 * LinkedHashSet：以元素插入的顺序来维护集合的链接表，允许以插入的顺序在集合中迭代；
 *
 * TreeSet：提供一个使用树结构存储Set接口的实现，对象以升序顺序存储，访问和遍历的时间很快。红黑树实现。
 *
 *
 * </pre>
 */
public class TestSet {

    @Test
    public void get() {

        HashSet<String> hashSet = new HashSet<>();
        put(hashSet);
        System.out.println("HashSet 顺序:\n" + hashSet);

        TreeSet<String> ts_hs = new TreeSet<>(hashSet);
        System.out.println("使用HashSet初始化的TreeSet 排序:\n" + ts_hs);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        put(linkedHashSet);
        System.out.println("LinkedHashSet 顺序:\n" + linkedHashSet);

        TreeSet<String> treeSet = new TreeSet<>();
        put(treeSet);
        System.out.println("TreeSet 顺序:\n" + treeSet);
    }

    private void put(Set set) {
        set.add("B");
        set.add("A");
        set.add("D");
        set.add("E");
        set.add("C");
        set.add("F");
        System.out.println("插入顺序:\n[B, A, D, E, C, F]");
    }
}