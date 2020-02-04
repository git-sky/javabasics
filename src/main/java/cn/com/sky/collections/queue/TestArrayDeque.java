package cn.com.sky.collections.queue;

import java.util.ArrayDeque;

/**
 * 数组实现的双端队列，默认大小16，
 */
public class TestArrayDeque {

    public static void main(String[] args) {

        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.add("a");
        ad.addFirst("b");
        ad.addLast("c");

        System.out.println(ad);

        ad.getFirst();
        ad.getLast();

    }

}
