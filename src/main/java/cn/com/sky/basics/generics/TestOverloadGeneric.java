package cn.com.sky.basics.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除
 */
public class TestOverloadGeneric {

    public static String method(List<String> list) {
        System.out.println("List<String> list");
        return "";
    }

//	 public static int method(List<Integer> list) {
//	 System.out.println("List<Integer> list");
//	 return 1;
//	 }

    public static void main(String args[]) {
        method(new ArrayList<String>());
        // method(new ArrayList<Integer>());
    }


    /**
     * 一个泛型类的所有实例在运行时具有相同的运行时类(class)，而不管他们的实际类型参数。
     * <p>
     * 事实上，泛型之所以叫泛型，就是因为它对所有其可能的类型参数，有同样的行为；同样的类可以被当作许多不同
     * 的类型。作为一个结果，类的静态变量和方法也在所有的实例间共享。这就是为什么在静态方法或静态初始化代码
     * 中或者在静态变量的声明和初始化时使用类型参数（类型参数是属于具体实例的）是不合法的原因。
     */
    @Test
    public void t() {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }

}
