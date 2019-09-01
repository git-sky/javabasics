package cn.com.sky.lamda;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestLamd {

    @Test
    public void test1() {

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};

        //数组转list
        List<String> players = Arrays.asList(atp);

        System.out.println("=================================");

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

        System.out.println("=================================");

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach(x -> System.out.print(x + "; "));

        System.out.println("=================================");


        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::print);

    }


    @Test
    public void test2() {


        List<Integer> realRoomIdList = Lists.newArrayList();
        Set<Long> longRealRoomIdList = realRoomIdList.stream().map(Long::valueOf).collect(Collectors.toSet());


        List<Long> mtaRoomIds = Lists.newArrayList();
        mtaRoomIds.add(1L);
        mtaRoomIds.add(2L);
        System.out.println(mtaRoomIds.contains(1L));

//        Set<Integer> a =mtaRoomIds.stream().map(Integer::intValue).collect(Collectors.toSet());
    }


}