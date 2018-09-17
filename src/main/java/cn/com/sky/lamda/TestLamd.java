package cn.com.sky.lamda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestLamd {

    @Test
    public void test1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
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
        players.forEach(System.out::println);

    }


}