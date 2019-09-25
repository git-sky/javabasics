package cn.com.sky.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestForEach4 {

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d");

        //遍历
        list.forEach(TestForEach4::printValur);

        //下面的方法和上面等价的
        Consumer<String> comsumer = TestForEach4::printValur;
        list.forEach(x -> comsumer.accept(x));


    }

}