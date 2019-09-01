package cn.com.sky.basics.anti_if.nullObject.replace;

import java.util.ArrayList;
import java.util.List;


/**
 * 解决方案： 使用NullObject或Optional类型替代。空集是很好的替代方案。
 */
public class TestNullObjectReplace {

    //使用空集
    public void example() {
        sumOf(new ArrayList<>());
    }

    private int sumOf(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }
}