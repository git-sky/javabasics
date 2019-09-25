package cn.com.sky.lamda.define;


/**
 * <pre>
 *
 * Lambda的基本语法为：
 *
 * (参数列表)-> 表达式
 *
 * 或者：
 *
 * (参数列表)-> {语句}
 *
 * </pre>
 */
@FunctionalInterface
public interface FunctionCorrect {

    String method1(String o1, String o2);

    default public String method2(Integer o1, Boolean o2) {
        return "why not rabbitmq or kafka?";
    }

    default public String method3(Integer o1, Boolean o2) {
        return "why not rabbitmq or kafka 222 ?";
    }
}