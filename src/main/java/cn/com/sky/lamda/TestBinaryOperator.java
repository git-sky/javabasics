package cn.com.sky.lamda;

import org.junit.Test;

import java.util.function.BinaryOperator;

public class TestBinaryOperator {

    @Test
    public void test() {
        BinaryOperator<Long> addLongs = (x, y) -> x + y;

        System.out.println(addLongs);
    }
}