package cn.com.sky.lamda;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class TestP {

    @Test
    public void test(){


        Predicate<Integer> atLeast5 = x -> x > 5;

        System.out.println(atLeast5.test(9));

        BinaryOperator<Long> addLongs = (x, y) -> x + y;

        System.out.println(addLongs);
    }

}
