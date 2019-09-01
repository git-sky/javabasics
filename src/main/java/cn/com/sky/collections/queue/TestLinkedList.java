package cn.com.sky.collections.queue;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

/**
 * 带有头指针和尾指针的双向链表实现的双端队列。
 */
public class TestLinkedList {

    @Test
    public void test1() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("a");
        list.addLast("b");
        list.add("c");
    }

    @Test
    public void traversal() {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(list.add(i + ""));
        }

        System.out.println("---------------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("---------------------------");
        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("---------------------------");
        ListIterator<String> listIter = list.listIterator();
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
        }

        System.out.println("---------------------------");
        ListIterator<String> listIter2 = list.listIterator(10);
        while (listIter2.hasPrevious()) {
            System.out.println(listIter2.previous());

        }
    }

    @Test
    public void test() {
        Map<String, String> map = Maps.newLinkedHashMap();
        map.put("3", "c");
        map.put("1", "a");
        map.put("4", "d");
        map.put("5", "e");
        map.put("2", "b");

        List<String> sortList = Lists.newLinkedList(map.values());
        for (String str : sortList) {
            System.out.println(str);
        }
    }
}
