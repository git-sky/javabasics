package cn.com.java8.method;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * filter方法
 */
public class StreamFilter {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 7, 1);

        System.out.println("========== filter ==========");
        List<Integer> result = list.stream().filter(i -> i % 2 == 0).collect(toList());
        System.out.println(result);

        System.out.println("========== distinct ==========");
        result = list.stream().distinct().collect(toList());
        System.out.println(result);

        System.out.println("========== skip ==========");
        result = list.stream().skip(50).collect(toList());
        System.out.println(result);

        System.out.println("========== limit ==========");
        result = list.stream().limit(50).collect(toList());
        System.out.println(result);

        System.out.println("========== forEach ==========");
        list.forEach(System.out::println);

        System.out.println("========== forEach ==========");
        list.forEach(i -> System.out.println(i));

        System.out.println("========== forEach ==========");
        list.forEach((i) -> System.out.println(i));

        System.out.println("========== forEach ==========");
        list.forEach((Integer i) -> System.out.println(i));

        System.out.println("========== for ==========");
        for (int i : list) {
            System.out.println(i);
        }
    }
}
