package cn.com.java8.method;

import cn.com.java8.collector.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * map方法
 */
public class StreamMap {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 7, 1);

        System.out.println("========== map ==========");
        List<Integer> result = list.stream().map(i -> i * 2).collect(toList());
        System.out.println(result);

        System.out.println("========== map forEach ==========");
        listDish().stream().map(d -> d.getName()).forEach(System.out::println);

        System.out.println("========== map collect==========");
        List<String> dishes = listDish().stream().map(d -> d.getName()).collect(toList());
        System.out.println(dishes);


        //flatmap flat (扁平化)
        System.out.println("========== flatmap flat ==========");

        String[] words = {"Hello", "World"};

        //{h,e,l,l,o},{W,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));//Stream<String[]>

        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.distinct().forEach(System.out::println);

    }


    private static List<Dish> listDish() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }
}