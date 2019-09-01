package cn.com.java8lambdasexercises.chapter5;


import cn.com.java8lambdasexercises.chapter1.Artist;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * 数据分块
 */
public class TestPartitioningBy {

    @Test
    public void toCollectionTreeset() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 5, 7, 9, 4, 6, 8);
        //输入顺序
//        List<Integer> list = stream.collect(Collectors.toList());
//        System.out.println(list);

        //TreeSet 可以对set集合中的元素进行排序，默认按照asic码表的自然顺序排序
        TreeSet<Integer> treeSet = stream.collect(toCollection(TreeSet::new));
        System.out.println(treeSet);
    }


    public static final Artist johnColtrane = new Artist("John Coltrane", "US");
    public static final Artist johnColtrane2 = new Artist("John Coltrane 2", "US");

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");
    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);
    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");


    public static final List<Artist> artistList = Arrays.asList(johnColtrane, johnColtrane2, theBeatles);


    @Test
    public void testMaxBy() {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        //找出成员最多的乐队
        Optional<Artist> optional = artistList.stream().collect(maxBy(comparing(getCount)));
        System.out.println(optional.get());
    }

    @Test
    public void testPartitioningBy() {
        //数据分块
        Map<Boolean, List<Artist>> map = artistList.stream().collect(partitioningBy(artist -> artist.isSolo()));
        System.out.println(map);
    }

    @Test
    public void testPartitioningByRef() {
        //数据分块（方法引用的方式实现）
        Map<Boolean, List<Artist>> map = artistList.stream().collect(partitioningBy(Artist::isSolo));
        System.out.println(map);
    }


}

