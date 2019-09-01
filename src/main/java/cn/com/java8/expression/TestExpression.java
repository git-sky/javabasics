package cn.com.java8.expression;


import org.junit.Test;

/**
 * 有且仅有一个方法（不包括default和static方法），才能成为函数接口。
 */
public class TestExpression {


    @Test
    public void testNone() {
        //无参数
        NoneParamInterface none1 = () -> {
            System.out.println("NoneParamInterface");
        };

        NoneParamInterface none2 = () ->
                System.out.println("NoneParamInterface");


        NoneParamReturnInterface noneR1 = () -> {
            return "NoneParamReturnInterface";
        };


        //一个参数，可以去掉参数类型，可以去掉小括号，可以去掉花括号。
        //完整模式
        OneParamInterface one1 = (String param) -> {
            System.out.println("OneParamInterface param=" + param);
        };
        //去掉：参数类型
        OneParamInterface one2 = (param) -> {
            System.out.println("OneParamInterface param=" + param);
        };
        //去掉：参数类型+小括号
        OneParamInterface one3 = param -> {
            System.out.println("OneParamInterface param=" + param);
        };
        //去掉：参数类型+小括号+花括号
        OneParamInterface one4 = param ->
                System.out.println("OneParamInterface param=" + param);


        //两个参数，可以去掉参数类型，可以去掉花括号。
        //完整模式
        TwoParamInterface two1 = (String p1, Integer p2) -> {
            System.out.println("TwoParamInterface p1=" + p1 + ",p2=" + p2);
        };
        TwoParamInterface two2 = (p1, p2) -> {
            System.out.println("TwoParamInterface p1=" + p1 + ",p2=" + p2);
        };
        TwoParamInterface two3 = (p1, p2) ->
                System.out.println("TwoParamInterface p1=" + p1 + ",p2=" + p2);

    }


    @Test
    public void testRun() {
        //lamda表达式
        Runnable r1 = () -> System.out.println("Hello");

        //方式1：匿名内部类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello"));
    }

    private static void process(Runnable r) {
        r.run();
    }

}