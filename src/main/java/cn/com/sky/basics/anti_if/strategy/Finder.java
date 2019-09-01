package cn.com.sky.basics.anti_if.strategy;

import org.junit.Test;

/**
 * 模式5：给出应对策略
 * <p>
 * <p>
 * 问题： 这类if语句增加了处理同一个对象或者数据结构的时间，其中包含隐藏耦合——null的情况。其它对象可能会返回其他代表没有结果的magic value。
 * <p>
 * 适用范围：最好将这类if语句放在一个地方，由于不会重复，我们就能将为空对象的magic value删除。
 * <p>
 * 解决方案：针对被调用代码，给出应对策略。Ruby的Hash#fetch就是很好的案例，Java也用到了类似的方法。这种模式也可以用在删除例外情况时。
 */
public class Finder {

    @Test
    public void test() {
        displayRecord(new Repository());
    }


    public String displayRecord(Repository repository) {
        String record = repository.getRecord(123);
        if (record == null) {
            return "Not found";
        } else {
            return record;
        }
    }
}
