package cn.com.sky.lamda;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class TestPredicate {

    @Test
    public void test() {
        Predicate<Integer> predicate = x -> x > 5;
        System.out.println(predicate.test(9));


    }

}
