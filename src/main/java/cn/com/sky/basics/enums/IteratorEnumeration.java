package cn.com.sky.basics.enums;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

/*
 * 测试分别通过 Iterator 和 Enumeration 去遍历Hashtable
 *
 */
public class IteratorEnumeration {

    public static void main(String[] args) {
        int val;
        Random r = new Random();
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        for (int i = 0; i < 100000; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);
            table.put(String.valueOf(i), val);
        }

        // 通过Iterator遍历Hashtable
        iterateHashtable(table);

        // 通过Enumeration遍历Hashtable
        enumHashtable(table);
    }

    /*
     * 通过Iterator遍历Hashtable
     */
    private static void iterateHashtable(Hashtable<String, Integer> table) {
        long startTime = System.currentTimeMillis();

        Iterator<?> iter = table.entrySet().iterator();
        while (iter.hasNext()) {
            // System.out.println("iter:"+iter.next());
            iter.next();
        }

        long endTime = System.currentTimeMillis();
        countTime(startTime, endTime);
    }

    /*
     * 通过Enumeration遍历Hashtable
     */
    private static void enumHashtable(Hashtable<String, Integer> table) {
        long startTime = System.currentTimeMillis();

        Enumeration<Integer> enu = table.elements();
        while (enu.hasMoreElements()) {
            // System.out.println("enu:"+enu.nextElement());
            enu.nextElement();
        }

        long endTime = System.currentTimeMillis();
        countTime(startTime, endTime);
    }

    private static void countTime(long start, long end) {
        System.out.println("time: " + (end - start) + "ms");
    }
}