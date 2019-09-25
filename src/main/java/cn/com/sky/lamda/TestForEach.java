package cn.com.sky.lamda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestForEach {

    @Test
    public void test1() {

        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};

        //数组转list
        List<String> players = Arrays.asList(atp);

        System.out.println("=================循环方式================");

        // 以前的循环方式
        for (String player : players) {
            System.out.println(player + "; ");
        }

        System.out.println("==================forEach方式===============");

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach(player -> System.out.println(player + "; "));


        System.out.println("==================双冒号操作符===============");
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

}