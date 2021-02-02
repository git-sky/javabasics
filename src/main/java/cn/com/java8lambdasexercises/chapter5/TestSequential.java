package cn.com.java8lambdasexercises.chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * stream的顺序
 */
public class TestSequential {

    @Test
    public void test() {
        for (int i = 0; i < 10000; i++) {
            //在一个有序集合中创建一个流时，流中的元素就按出现顺序排列。
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 5, 1);
            List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
            Assert.assertEquals(numbers, sameOrder);
        }
    }

    @Test
    public void test1() {
        for (int i = 0; i < 100000; i++) {
            //如果集合本身就是无序的，由此生成的流也是无序的。
            Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1, 5, 7, 11));
            List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
            // 该断言有时会失败
            Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7, 11), sameOrder);
        }
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10000; i++) {
            Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));
            List<Integer> sameOrder = numbers.stream().sorted().collect(Collectors.toList());
            Assert.assertEquals(Arrays.asList(1, 2, 3, 4), sameOrder);
        }
    }


}