package cn.com.sky.basics.generics;

/**
 * 泛型方法
 */
class GenMethod {
    public <T> T fun(T t) { // 可以接收任意类型的数据
        return t; // 直接把参数返回
    }
}

public class TestGenericMethod {

    public static void main(String args[]) {
        GenMethod genMethod = new GenMethod();

        String name = genMethod.fun("Tom");
        System.out.println(name);

        int age = genMethod.fun(30);
        System.out.println(age);


        //在这种情况(实际也是大多数情况)下， 方法调用中可以省略 <String> 类型参数。编译 器有足够的信息能够推断出所调用的方法。
        String hh = genMethod.<String>fun("abc");
        System.out.println(hh);

        String jj = genMethod.fun("abc");
        System.out.println(jj);

    }
}