package cn.com.sky.lamda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {


//        一、流的初始化与转换：

    @Test
    public void startStream() {


//        Java中的Stream的所有操作都是针对流的，所以，使用Stream必须要得到Stream对象：

//        1、初始化一个流：
        Stream stream = Stream.of("a", "b", "c");

//        2、数组转换为一个流：
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
//        或者
        stream = Arrays.stream(strArray);

//        3、集合对象转换为一个流（Collections）：
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();


    }


//
//    二、流的操作：
//    流的操作可以归结为几种：


    //    1、遍历操作(map)：
//    使用map操作可以遍历集合中的每个对象，并对其进行操作，map之后，用.collect(Collectors.toList())会得到操作后的集合。
    @Test
    public void testMap() {

        List<String> wordList = Arrays.asList("a", "ab", "abc", "abcd");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        System.out.println(output);


        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);
    }


    //    2、过滤操作(filter)：
//    使用filter可以对象Stream中进行过滤，通过测试的元素将会留下来生成一个新的Stream。
    @Test
    public void testFilter() {

//        2.1、得到其中不为空的String

        List<String> filterLists = new ArrayList<>();
        filterLists.add("");
        filterLists.add("a");
        filterLists.add("b");
        List afterFilterLists = filterLists.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        System.out.println(filterLists);
        System.out.println(afterFilterLists);
    }


    //        3、循环操作(forEach):
//        如果只是想对流中的每个对象进行一些自定义的操作，可以使用forEach：
    @Test
    public void testForEach() {

        List<String> forEachLists = new ArrayList<>();
        forEachLists.add("a");
        forEachLists.add("b");
        forEachLists.add("c");
        forEachLists.stream().forEach(s -> System.out.println(s));
        forEachLists.stream().forEach(s -> s.toUpperCase());
        System.out.println(forEachLists);


        Map<Long, Integer> mtdp = Maps.newHashMap();
        mtdp.put(1L, 111);
        mtdp.put(2L, 222);
        mtdp.put(3L, 333);


        List<Student> poiInfoList = Lists.newArrayList();
        poiInfoList.add(new Student(1L, "aaa", 0));

        poiInfoList.stream().forEach(s -> s.setAge(mtdp.get(s.getId())));

        System.out.println(poiInfoList);

        poiInfoList.stream().forEach(s -> System.out.println(s));
    }


    //        4、返回特定的结果集合（limit/skip）：
//        limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素:
    @Test
    public void testSkip() {

        List<String> forEachLists = new ArrayList<>();
        forEachLists.add("a");
        forEachLists.add("b");
        forEachLists.add("c");
        forEachLists.add("d");
        forEachLists.add("e");
        forEachLists.add("f");
        List<String> limitLists = forEachLists.stream().skip(2).limit(3).collect(Collectors.toList());

        System.out.println(limitLists);

//        注意skip与limit是有顺序关系的，比如使用skip(2)会跳过集合的前两个，返回的为c、d、e、f,然后调用limit(3)会返回前3个，所以最后返回的c,d,e

    }


    //            5、排序（sort/min/max/distinct）：
//        sort可以对集合中的所有元素进行排序。max，min可以寻找出流中最大或者最小的元素，而distinct可以寻找出不重复的元素：
    @Test
    public void testSort() {
//            对一个集合进行排序：
        List<Integer> sortLists = new ArrayList<>();
        sortLists.add(1);
        sortLists.add(4);
        sortLists.add(6);
        sortLists.add(3);
        sortLists.add(2);
        List<Integer> afterSortLists = sortLists.stream().sorted((In1, In2) ->
                In1 - In2).collect(Collectors.toList());

        System.out.println(afterSortLists);
    }

    @Test
    public void testMax() {
//        得到其中长度最大的元素：
        List<String> maxLists = new ArrayList<>();
        maxLists.add("a");
        maxLists.add("b");
        maxLists.add("c");
        maxLists.add("d");
        maxLists.add("e");
        maxLists.add("f");
        maxLists.add("hahaha");
        int maxLength = maxLists.stream().mapToInt(s -> s.length()).max().getAsInt();
        System.out.println("字符串长度最长的长度为" + maxLength);
    }


    @Test
    public void testDistinct() {
//        对一个集合进行查重：

        List<String> distinctList = new ArrayList<>();
        distinctList.add("a");
        distinctList.add("a");
        distinctList.add("c");
        distinctList.add("d");
        List<String> afterDistinctList = distinctList.stream().distinct().collect(Collectors.toList());

        System.out.println(afterDistinctList);

        //        其中的distinct()方法能找出stream中元素equal()，即相同的元素，并将相同的去除，上述返回即为a,c,d。

    }


//    6、匹配(Match方法)：
//    有的时候，我们只需要判断集合中是否全部满足条件，或者判断集合中是否有满足条件的元素，这时候就可以使用match方法：
//    allMatch：Stream 中全部元素符合传入的 predicate，返回 true
//    anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
//    noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true

    @Test
    public void testMatch() {
//        判断集合中没有有为‘c’的元素：
        List<String> matchList = new ArrayList<>();
        matchList.add("a");
        matchList.add("a");
        matchList.add("c");
        matchList.add("d");

        boolean isExits = matchList.stream().anyMatch(s -> s.equals("c"));
        System.out.println(isExits);
    }

    @Test
    public void testNonMatch() {
//   判断集合中是否全不为空：
        List<String> matchList = new ArrayList<>();
        matchList.add("a");
        matchList.add("");
        matchList.add("a");
        matchList.add("c");
        matchList.add("d");
        boolean isNotEmpty = matchList.stream().noneMatch(s -> s.isEmpty());
        System.out.println(isNotEmpty);
//        则返回的为false
    }
}
