package cn.com.sky.basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * <pre>
 *
 * Arrays类使用
 *
 * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的add/remove/clear方法会抛出UnsupportedOperationException异常。
 * 说明：asList的返回对象是一个Arrays内部类，并没有实现集合的修改方法。
 * Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
 * String[] str = new String[] { "a", "b" };
 * List list = Arrays.asList(str);
 * 第一种情况：list.add("c"); 运行时异常。
 * 第二种情况：str[0]= "gujin"; 那么list.get(0)也会随之修改。
 *
 * </pre>
 */
public class TestArrays {

    @Test
    public void test_asList() {
        String[] arr = new String[]{"a", "b"};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("==================================");

        List<String> list = Arrays.asList(arr);
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String str = iterator.next();
            System.out.println(str);
        }

        System.out.println("==================================");
        for (String s : list) {
            System.out.println(s);
        }

//		list.add("a");
        arr[1] = "c";

        System.out.println("================修改arr==================");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("==================================");
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String str = iterator.next();
            System.out.println(str);
        }

        System.out.println("==================================");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test_ListsPartition() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<List<Integer>> groupList = Lists.partition(list, 2);
        for (List<Integer> subList : groupList) {
//            subList.add(4);//报错
            System.out.println(subList);
        }
    }

    @Test
    public void test_toString() {
        int[] arr = new int[10];

        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(100);
        }

        //输出：[I@11531931
        System.out.println(arr);

        //可视化输出；例如：[51, 91, 57, 82, 18, 1, 30, 35, 42, 6]
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int pos = Arrays.binarySearch(arr, 15);
        System.out.println(pos);

    }

    @Test
    public void test4() {
        int[] a1 = new int[]{1, 2, 3};

        String[] a2 = new String[]{"a", "b", "c"};

        Integer[] a3 = new Integer[]{4, 5, 6};

        // JDK5中asList接受变长参数表了，把a1作为单独的参数传递给asList方法的时候，编译器会把它当作一个Object处理，于是返回了只有一个元素的List，而这个元素应该就是指向int[]的引用。
        System.out.println(Arrays.asList(a1));//int[]类型输出：[[I@4563e9ab]
        System.out.println(Arrays.toString(a1));

        System.out.println(Arrays.asList(a2));
        System.out.println(Arrays.toString(a2));

        System.out.println(Arrays.asList(a3));//Integer[]类型输出：[4, 5, 6]
        System.out.println(Arrays.toString(a3));

    }

    /**
     * 数组转集合& 集合转数组
     */
    @Test
    public void test5() {
        List<People> peopleList = new ArrayList<>();
        People[] peopleArray = new People[5];
        for (int i = 0; i < peopleArray.length; i++) {
            peopleArray[i] = new People("sky-" + i);
            peopleList.add(new People("sky-" + i));
        }

        System.out.println("--------- 数组转集合 ---------");
        List<People> list = Arrays.asList(peopleArray);
        for (Iterator<People> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
        System.out.println("==============");
        for (People people : list) {
            System.out.println(people);
        }


        System.out.println("--------- 集合转数组 ---------");
        People[] s = peopleList.toArray(new People[0]);// 集合转数组
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        System.out.println("--------- 集合转Object数组 ---------");
        Object[] obj = peopleList.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }

        System.out.println("--------- 集合强转数组成功 ---------");
        People[] lobj = (People[]) list.toArray();// Arrays.asList()产生的list会成功。
        for (int i = 0; i < lobj.length; i++) {
            System.out.println(lobj[i].getName());
        }

        System.out.println("--------- 集合强转数组失败 ---------");
        People[] sobj = (People[]) peopleList.toArray();// 正常的list会失败。
        for (int i = 0; i < sobj.length; i++) {
            System.out.println(sobj[i].getName());
        }

    }

    private final class People {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        People(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "People [name=" + name + "]";
        }
    }
}
