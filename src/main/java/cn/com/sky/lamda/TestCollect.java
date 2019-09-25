package cn.com.sky.lamda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect {

    //collect(toList()) 方法由 Stream 里的值生成一个列表，是一个及早求值操作。
    @Test
    public void test() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);

    }

    //如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以使用该函数，将一个流中的值转换成一个新的流。
    @Test
    public void testMap() {
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String up = string.toUpperCase();
            collected.add(up);
        }
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

        List<String> collected2 = Stream.of("a", "b", "hello").map(s -> s.toUpperCase()).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected2);
    }

    //遍历数据并检查其中的元素时，可尝试使用 Stream 中提供的新方法 filter
    @Test
    public void testFilter() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
        Assert.assertEquals(Arrays.asList("1abc"), beginningWithNumbers);


        List<String> beginningWithNumbers2
                = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("1abc"), beginningWithNumbers2);

    }


    //flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream。
    @Test
    public void testFlatMap() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }


    @Test
    public void testReduce() {
        //方式1
        int count1 = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        Assert.assertEquals(6, count1);

        //方式2
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count2 = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
        System.out.println(count2);

        //方式3
//       使用命令式编程方式求和
        int acc = 0;
        for (Integer element : Arrays.asList(1, 2, 3)) {
            acc = acc + element;
        }
        Assert.assertEquals(6, acc);

    }

}
