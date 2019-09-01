package cn.com.java8lambdasexercises.chapter4.default_method;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 重载参数类型推导，javac会挑出最具体的类型。
 *
 * <pre>
 * 总而言之，Lambda 表达式作为参数时，其类型由它的目标类型推导得出，推导过程遵循如下规则:
 * • 如果只有一个可能的目标类型，由相应函数接口里的参数类型推导得出;
 * • 如果有多个可能的目标类型，由最具体的类型推导得出;
 * • 如果有多个可能的目标类型且最具体的类型不明确，则需人为指定类型。
 * </pre>
 */
public class TestOverload {

    @Test
    public void test() {
        //参数类型推导，javac会挑出最具体的类型。String
        overloadedMethod("abc");
    }


    private void overloadedMethod(Object o) {
        System.out.print("Object");
    }

    private void overloadedMethod(String s) {
        System.out.print("String");
    }


    @Test
    public void testLamda() {
        //Java 推导出的 Lambda 表达式的类型是最具体的函数接口的类型。IntegerBiFunction
        overloadedMethod((x, y) -> x + y);
    }


    private interface IntegerBiFunction extends BinaryOperator<Integer> {
    }

    private void overloadedMethod(BinaryOperator<Integer> Lambda) {
        System.out.print("BinaryOperator");
    }

    private void overloadedMethod(IntegerBiFunction Lambda) {
        System.out.print("IntegerBinaryOperator");
    }


    @Test
    public void testLamdaE() {
        //javac 就无法编译。IntPredicate 没有继承 Predicate，因此编译器无法推断出哪个类型更具体。
//        overloadedMethod((x) -> true);
    }


    private interface IntPredicate {
        public boolean test(int value);
    }

    private void overloadedMethod(Predicate<Integer> predicate) {
        System.out.print("Predicate");
    }

    private void overloadedMethod(IntPredicate predicate) {
        System.out.print("IntPredicate");
    }
}