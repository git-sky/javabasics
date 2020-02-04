package cn.com.sky.basics.test_equals;

import java.util.Objects;

import org.junit.Test;

/**
 * <pre>
 *
 * 【强制】Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals。
 * 正例： "test".equals(object);
 * 反例： object.equals("test");
 * 说明：推荐使用java.util.Objects#equals （JDK7引入的工具类）
 *
 * </pre>
 */
public class TestEquals2 {
    @Test
    public void test() {

        Object obj = null;

        System.out.println("test".equals(obj));
//		System.out.println(obj.equals("test"));// java.lang.NullPointerException
        System.out.println(Objects.equals(obj, "test"));
        System.out.println(Objects.equals("test", obj));
    }

}
