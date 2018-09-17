package cn.com.sky.lamda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestArrayLamda {


    @Test
    public void test() {

        List<String> list = Arrays.asList("2", "3", "1", "4");
        System.out.println(list);


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1) - Integer.valueOf(o2);
            }
        };


        //
//        list.sort(comparator);

        System.out.println(list);


        //
//        list.sort((String o1, String o2) -> Integer.valueOf(o1) - Integer.valueOf(o2));
//
//        System.out.println(list);
//
//
//        list.sort((o1, o2) -> Integer.valueOf(o1) - Integer.valueOf(o2));
//        System.out.println(list);
//
//        list.sort((o1, o2) -> Integer.valueOf(o1).compareTo(Integer.valueOf(o2)));
//        System.out.println(list);

        list.sort(Comparator.comparing(Integer::valueOf));
        System.out.println(list);


    }


    @Test
    public void tset() {

        List<String> nations = Arrays.asList("A", "B", "C");


//        Set<String> nationalities = new HashSet<>();
//        for (String nation : nations) {
//            if (nation.startsWith("A")) {
//                System.out.println("Found nationality: " + nation);
//                nationalities.add(nation);
//            }
//        }
//
//        System.out.println(nationalities);


        nations.stream().filter((s) -> s.startsWith("A")).forEach(
                nationality -> System.out.println("Found: " + nationality));


        nations.stream().filter((s) -> s.startsWith("A"))
                .map((param) -> param + "/")
                .forEach(nationality -> System.out.println("Found: " + nationality));

    }


    @Test
    public void test1() {

        List<String> nations = Arrays.asList("A", "B", "C", "A1");

        nations.stream().
                filter(nation -> {
                    return nation.startsWith("A");
                }).
                peek(nation -> System.out.println(nation)).
                map((t) -> {
                    return t + "a";
                }).
                peek(nation -> System.out.println(nation)).
                collect(Collectors.toList());
    }


}
