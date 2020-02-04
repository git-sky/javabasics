package cn.com.sky.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

public class TestMapSort {

    @Test
    public void test() {
        /**
         * Integer实现了 Comparable接口
         */
        TreeMap<Integer, String> teMap = new TreeMap<>();
        teMap.put(10, "Value10");
        teMap.put(3, "Value311");
        teMap.put(1, "Value1");
        teMap.put(30, "Value30");
        teMap.put(2, "Value2");

        Iterator<Entry<Integer, String>> tit = teMap.entrySet().iterator();
        while (tit.hasNext()) {
            Map.Entry<Integer, String> e = tit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }

    public static void main(String[] args) {

        // HashMap
        System.out.println("------HashMap无序输出------");
        HashMap<String, String> hsMap = new HashMap<>();
        hsMap.put("10", "Value10");
        hsMap.put("3", "Value3");
        hsMap.put("1", "Value1");
        hsMap.put("2", "Value2");
        hsMap.put("b", "ValueB");
        hsMap.put("a", "ValueA");
        Iterator<Entry<String, String>> it = hsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }

        // TreeMap
        /**
         * String实现了 Comparable接口
         */
        System.out.println("------TreeMap按Key排序输出------");
        TreeMap<String, String> teMap = new TreeMap<String, String>();
        teMap.put("10", "Value10");
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        Iterator<Entry<String, String>> tit = teMap.entrySet().iterator();
        while (tit.hasNext()) {
            Map.Entry<String, String> e = tit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }

        // LinkedHashMap
        System.out.println("--LinkedHashMap根据输入的顺序输出--");
        LinkedHashMap<String, String> lhsMap = new LinkedHashMap<String, String>();
        lhsMap.put("10", "Value10");
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        Iterator<Entry<String, String>> lit = lhsMap.entrySet().iterator();
        while (lit.hasNext()) {
            Map.Entry<String, String> e = lit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }

}
