package cn.com.sky.basics.anti_if.nullObject;

import java.util.List;

/**
 * 模式3：NullObject/Optional
 * <p>
 * 问题： 在方法中，必须确认传递内容非null值。
 * <p>
 * 适用范围：对外部访问代码库来说，这种做法很必要。但在代码库内部，也许这代表着你的代码写得太严格了。
 * <p>
 * 解决方案： 使用NullObject或Optional类型替代。空集是很好的替代方案。
 */
public class TestNullObject {

    public void example() {
        sumOf(null);
    }

    private int sumOf(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }

        return numbers.stream().mapToInt(i -> i).sum();
    }

}