package cn.com.sky.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestArrayListAdd {

    @Test
    public void testAdd() {
        List result = new ArrayList();
        List result2 = new ArrayList();

        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        result.addAll(collection);// 把list中的每一个元素加到result中，result.size()==list.size()
        result2.add(collection);// 将list作为一个元素加到result中，则result.size()为1

        System.out.println(result.size());// 4
        System.out.println(result2.size());// 1

        System.out.println("-------------------");

        for (Object obj : result) {
            System.out.println(obj);
        }

        System.out.println("-------------------");

        for (Object obj : result2) {
            System.out.println(obj);
        }


        System.out.println("------------");
        System.out.println(result.contains("d"));
        System.out.println(result.contains(collection));
        System.out.println(result.containsAll(collection));

        System.out.println("------------");
        System.out.println(result2.contains("d"));
        System.out.println(result2.contains(collection));
        System.out.println(result2.containsAll(collection));

    }

}
