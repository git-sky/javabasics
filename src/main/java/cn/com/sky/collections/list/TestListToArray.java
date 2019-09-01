package cn.com.sky.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import cn.com.sky.alpha_work.Person;

/**
 * <pre>
 *
 * 【强制】使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()。
 *
 * 反例：直接使用toArray无参方法存在问题，此方法返回值只能是Object[]类，若强转其它类型数组将出现ClassCastException错误。
 *
 * </pre>
 */
public class TestListToArray {

    @Test
    public void test1() {

        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");

        //集合转数组，不要使用这个方法，因为返回的是 Object[]，容易出错。
        for (Object obj : list.toArray()) {
            System.out.println(obj);
        }
        System.out.println("------------------------");

        String[] arr = new String[list.size()];
        //【强制】集合转数组使用这个方法。
        for (String str : list.toArray(arr)) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {

        List<Person> personList = new ArrayList<>();
        System.out.println("size=" + personList.size());

        Person p = new Person("aaa", 10);
        personList.add(p);
        p = new Person("bbb", 15);
        personList.add(p);
        p = new Person("ccc", 23);
        personList.add(p);

        System.out.println("size=" + personList.size());// 3 ,为什么呢？

        for (Object a : personList.toArray()) {
            System.out.println(((Person) a).getName());
            try {
                System.out.println(JSON.toJSONString(a));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test3() {

        ArrayList<Object> alist = new ArrayList<>();
        alist.add(new Point(1, 1));
        alist.add(new Point(2, 2));
        alist.add(new Point(3, 3));
        alist.add(4);
        alist.add(5);

        Object[] obj = alist.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }

        System.out.println("-------------------------");

        List<Object> asList = Arrays.asList(obj);
        System.out.println(asList);

        System.out.println("-------------------------");

        Iterator<Object> it = asList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}