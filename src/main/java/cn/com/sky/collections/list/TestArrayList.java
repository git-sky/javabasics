package cn.com.sky.collections.list;

import cn.com.sky.collections.list.domain.Model;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

/**
 * 底层是数组结构， 初始化大小10，每次扩容50%，如果不够，直接扩容到需要的大小。
 *
 * <pre>
 *
 *   private void grow(int minCapacity) {
 *         // overflow-conscious code
 *         int oldCapacity = elementData.length;
 *         int newcapacity = oldCapacity + (oldCapacity >> 1);//扩容50%
 *         if (newCapacity - minCapacity < 0)
 *             newCapacity = minCapacity;//直接扩容到需要的大小。
 *         if (newCapacity - MAX_ARRAY_SIZE > 0)
 *             newCapacity = hugeCapacity(minCapacity);
 *         // minCapacity is usually close to size, so this is a win:
 *         elementData = Arrays.copyOf(elementData, newCapacity);
 * }
 *
 *
 *  Iterator 和 ListIterator 区别：
 *
 * 一．相同点
 *
 * 都是迭代器，当需要对集合中元素进行遍历不需要干涉其遍历过程时，这两种迭代器都可以使用。
 *
 * 二．不同点
 *
 * 1.使用范围不同，Iterator可以应用于所有的集合，Set、List和Map和这些集合的子类型。而ListIterator只能用于List及其子类型。
 *
 * 2.ListIterator有add方法，可以向List中添加对象，而Iterator不能。
 *
 * 3.ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator不可以。
 *
 * 4.ListIterator可以定位当前索引的位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
 *
 * 5.都可实现删除操作，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。
 *
 * <pre>
 */
public class TestArrayList {

    @Test
    public void init() {
        //初始化list
        List<String> list = new ArrayList<String>() {
            {
                add("A");
                add("B");
                add("C");
            }
        };
        System.out.println(list);
        System.out.println(list.toArray());
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * list遍历
     */
    @Test
    public void traversal() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        System.out.println("-------------遍历list=for--------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
            // list.remove(i);
        }

        System.out.println();
        System.out.println("-------------遍历list=iterator--------------");

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("-------------遍历list=listIterator--------------");

        ListIterator<String> listIter = list.listIterator();
        while (listIter.hasNext()) {
            System.out.print(listIter.next());
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("---------------------------");

        ListIterator<String> listIter2 = list.listIterator(10);
        while (listIter2.hasPrevious()) {
            System.out.print(listIter2.previous());
            System.out.print(" ");
        }
    }

    /**
     * 【强制】在subList场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、删除均产生ConcurrentModificationException 异常。
     * <p>
     * 【强制】ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常：java.util.RandomAccessSubList
     * cannot be cast to java.util.ArrayList ; 说明：subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList
     * ，而是 ArrayList 的一个视图，对于SubList子列表的所有操作最终会反映到原列表上。
     */
    @Test
    public void testSubList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next());
            System.out.print(" ");
        }

        printNewLine();

        List<Integer> subList = list.subList(3, 5);

        // list.add(3);// 对原集合元素个数的修改，会导致子列表产生ConcurrentModificationException异常

        for (Iterator<Integer> iter = subList.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next());
            System.out.print(" ");
        }

        printNewLine();

        subList.add(4);//对子列表的修改，会改变原列表。

        for (Iterator<Integer> iter = subList.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next());
            System.out.print(" ");
        }

        printNewLine();

        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next());
            System.out.print(" ");
        }

    }

    private void printNewLine() {
        System.out.println();
        System.out.println("-----------------------------");
    }

    @Test
    public void testForGetEmpty() {
        ArrayList list = Lists.newArrayList();
        //抛出异常 IndexOutOfBoundsException
        System.out.println(list.get(0));
    }


    @Test
    public void testForNullList() {
        List<Integer> list = null;
        //可以正常输出 null
        System.out.println(list);
        System.out.println("begin");

        //list是null时，遍历会抛出异常 NullPointerException
        for (Integer attrVal : list) {
            System.out.println(attrVal);
        }
        System.out.println("over");
    }

    @Test
    public void testForNullElement() {
        List<Integer> list = Lists.newArrayList();
        list.add(null);
        System.out.println(list);
        System.out.println("begin");

        //list中的null元素，可以正常输出
        for (Integer attrVal : list) {
            System.out.println(attrVal);
        }
        System.out.println("over");
    }


    @Test
    public void testit() {
        List list1 = Lists.newArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List listx = Arrays.asList(1, 2, 3);

        list1.addAll(listx);

        System.out.println(list1);


        Map<Integer, Integer> maps = Maps.newHashMap();
        maps.put(1, 1);
        maps.put(3, 1);


        if (maps != null && maps.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
                list1.removeAll(maps.keySet());
                //.remove(entry.getKey());
            }
        }

        System.out.println(list1);
    }

    @Test
    public void testForPrintList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("list1=" + list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(new Integer(1));
        list2.add(new Integer(2));
        list2.add(new Integer(3));
        System.out.println("list2=" + list2);

        //复合类型需要实现toString方法，才能输出可视化展示。
        List<Model> list3 = new ArrayList<>();
        list3.add(new Model(1, "a"));
        list3.add(new Model(2, "b"));
        System.out.println("list3=" + list3);


        Set<Integer> set = new HashSet<>();
        set.add(new Integer(1));
        set.add(new Integer(2));
        System.out.println(set);
    }

}
