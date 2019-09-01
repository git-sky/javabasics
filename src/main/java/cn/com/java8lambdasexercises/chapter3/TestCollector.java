package cn.com.java8lambdasexercises.chapter3;

import cn.com.java8lambdasexercises.chapter1.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 方法
 */
public class TestCollector {

    @Test
    public void test_collect() {
        //collect(toList()) 方法由 Stream 里的值生成一个列表，是一个及早求值操作。
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);
    }

    @Test
    public void test_map() {
        //如果有一个函数可以将一种类型的值转换成另外一种类型，map操作就可以使用该函数，将一个流中的值转换成一个新的流。

        //使用for
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

        //使用map
        List<String> collected_map = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected_map);

    }

    @Test
    public void test_filter() {
        // filter 模式
        //for方法
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
        Assert.assertEquals(Arrays.asList("1abc"), beginningWithNumbers);


        //使用filter方法替换
        List<String> beginningWithNumbers_filter
                = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
    }


    @Test
    public void test_flatMap() {
        //flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream。
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }


    @Test
    public void test_max_min() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));


        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }
        Assert.assertEquals(tracks.get(1), shortestTrack);

        //min
        Track shortestTrack_min = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        Assert.assertEquals(tracks.get(1), shortestTrack_min);

        //max
        Track shortestTrack_max = tracks.stream()
                .max(Comparator.comparing(track -> track.getLength()))
                .get();
        Assert.assertEquals(tracks.get(0), shortestTrack_max);
    }

    @Test
    public void test_reduce() {
        //for方式
        int total = 0;
        for (Integer element : Arrays.asList(1, 2, 3)) {
            total = total + element;
        }
        Assert.assertEquals(6, total);

        //reduce方式
        //reduce 操作可以实现从一组值中生成一个值。在上述例子中用到的count、min和max方法，因为常用而被纳入标准库中。事实上，这些方法都是reduce 操作。
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        Assert.assertEquals(6, count);
    }


}