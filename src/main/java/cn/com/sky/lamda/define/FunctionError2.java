package cn.com.sky.lamda.define;

/**
 * FunctionalInterface，必须有且只有一个抽象方法
 */
//@FunctionalInterface
public interface FunctionError2 {
    String method1(String o1, String o2);

    String method2(Integer o1, Boolean o2);

    default String method3(Integer o1, Boolean o2) {
        return "1";
    };


}