package cn.com.sky.basics.generics.generic_method;

/**
 * 泛型方法
 */
public class GenMethod {

    public <T> T fun(T t) { // 可以接收任意类型的数据
        // 直接把参数返回
        return t;
    }

}