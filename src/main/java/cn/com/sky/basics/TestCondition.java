package cn.com.sky.basics;

import org.junit.Test;

/**
 * <pre>
 *
 * 【强制】三目运算符 condition? 表达式1 : 表达式2 中，高度注意表达式1 和 2 在类型对齐时，可能抛出因自动拆箱导致的 NPE 异常。
 *
 * 说明:以下两种场景会触发类型对齐的拆箱操作:
 * 1) 表达式 1 或表达式 2 的值只要有一个是原始类型。
 * 2) 表达式 1 或表达式 2 的值的类型不一致，会强制拆箱升级成表示范围更大的那个类型。
 *
 * Integer a = 1;
 * Integer b = 2;
 * Integer c = null;
 * Boolean flag = false;
 *
 * // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
 * Integer result=(flag? a*b : c);
 *
 *
 * </pre>
 */
public class TestCondition {

    @Test
    public void test1() {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
        Integer result = (flag ? a * b : c);
    }

    @Test
    public void test2() {
        Boolean flag = false;
        int a = 1;
        Integer c = null;
        // a 是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
        Integer result = flag ? a : c;
    }

}