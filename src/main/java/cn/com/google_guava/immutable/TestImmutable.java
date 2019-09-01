package cn.com.google_guava.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

public class TestImmutable {

    /**
     * JDK中实现immutable集合。
     * <p>
     * Collections.unmodifiableList实现的不是真正的不可变集合，当原始集合修改后，不可变集合也发生变化。
     */
    @Test
    public void testJDKImmutable() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        List<String> unmodifiableList = Collections.unmodifiableList(list);

        System.out.println(unmodifiableList);

        List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        System.out.println(unmodifiableList1);

        String temp = unmodifiableList.get(1);
        System.out.println("unmodifiableList [0]：" + temp);

        list.add("baby");
        System.out.println("list add a item after list:" + list);
        System.out.println("list add a item after unmodifiableList:" + unmodifiableList);

        unmodifiableList1.add("bb");
        System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);

        unmodifiableList.add("cc");
        System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
    }

    /**
     * <pre>
     *
     *     Immutable集合使用方法：
     * 　　一个immutable集合可以有以下几种方式来创建：
     * 　　1.用copyOf方法, 譬如, ImmutableSet.copyOf(set)
     * 　　2.使用of方法，譬如，ImmutableSet.of("a", "b", "c")或者ImmutableMap.of("a", 1, "b", 2)
     * 　　3.使用Builder类
     *
     *
     * </pre>
     */
    @Test
    public void testGuavaImmutable() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list：" + list);

        ImmutableList<String> imlist = ImmutableList.copyOf(list);
        System.out.println("imlist：" + imlist);

        ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
        System.out.println("imOflist：" + imOflist);

        ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println("imSortList：" + imSortList);

        list.add("baby");
        System.out.println("list add a item after list:" + list);
        System.out.println("list add a item after imlist:" + imlist);

//        ImmutableSet<Color> imColorSet =
//                ImmutableSet.<Color>builder()
//                        .add(new Color(0, 255, 255))
//                        .add(new Color(0, 191, 255))
//                        .build();
//
//        System.out.println("imColorSet:" + imColorSet);
    }


    @Test
    public void testCotyOf() {
        ImmutableSet<String> imSet = ImmutableSet.of("peida", "jerry", "harry", "lisa");
        System.out.println("imSet：" + imSet);

        ImmutableList<String> imlist = ImmutableList.copyOf(imSet);
        System.out.println("imlist：" + imlist);

        ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet：" + imSortSet);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "x");
        }
        System.out.println("list：" + list);

        ImmutableList<String> imInfolist = ImmutableList.copyOf(list.subList(2, 18));
        System.out.println("imInfolist：" + imInfolist);

        int imInfolistSize = imInfolist.size();
        System.out.println("imInfolistSize：" + imInfolistSize);

        ImmutableSet<String> imInfoSet = ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize - 3));
        System.out.println("imInfoSet：" + imInfoSet);
    }
}