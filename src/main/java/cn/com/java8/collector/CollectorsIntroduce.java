package cn.com.java8.collector;

import cn.com.java8.filter.Apple;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


/**
 * 使用Collectors实现分组
 */
public class CollectorsIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
                , new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170));

        System.out.println("======================== greenList ===========================");
        List<Apple> greenList = list.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);

        System.out.println("======================= groupByNormal ============================");
        System.out.println(list);
        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);

        System.out.println("======================== groupByFunction ===========================");
        System.out.println(list);
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);

        System.out.println("========================= groupByCollector ==========================");
        System.out.println(list);
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
    }

    //传统方式
    private static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : apples) {
            List<Apple> list = map.get(a.getColor());
            if (null == list) {
                list = new ArrayList<>();
                map.put(a.getColor(), list);
            }
            list.add(a);
        }
        return map;
    }

    //普通lamda方式
    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.parallelStream().forEach(a -> {
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(), list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    //Collectors.groupingBy方式
    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
        return apples.parallelStream().collect(groupingBy(Apple::getColor));
    }
}