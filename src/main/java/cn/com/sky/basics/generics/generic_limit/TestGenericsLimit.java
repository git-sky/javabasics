package cn.com.sky.basics.generics.generic_limit;

import org.junit.Test;

/**
 * 范型的约束和局限性.
 */
public class TestGenericsLimit {

    //1、不能用基本类型实例化类型参数。
    @Test
    public void test1() {
//        类型参数不能是基本类型。因此，没有Pair<double>, 只有Pair<Double>。
//        其原因是类型擦除。
//        擦除之后， Pair 类含有 Object 类型的域， 而 Object 不能存储 double值。

        Pair<Double> pair = null;
//        Pair<double> p=null;
    }

    //2、运行时类型查询只适用于原始类型。
    @Test
    public void test2() {
        Object a = new Object();
//        if (a instanceof Pair<String>) { // 报错
//        }
//
//        if (a instanceof Pair<T>) { // 报错
//        }

//        Pair<String> p = (Pair<String>) a; // Warning-can only test that a is a Pair


//        同样的道理，getClass 方法总是返回原始类型。例如:
        Pair<String> stringPair = new Pair<>();
        Pair<Object> employeePair = new Pair<>();

        //其比较的结果是true, 这是因为两次调用getClass都将返回Pair.clas。
        if (stringPair.getClass() == employeePair.getClass()) {
            System.out.println(true);
        }
    }


    //3、不能创建参数化类型的数组。
    @Test
    public void test3() {
//        不能实例化参数化类型的数组， 例如:
//        Pair<String>[] table = new Pair<String>[10]; // Error

//        需要说明的是， 只是不允许创建这些数组， 而声明类型为 Pair<String>[] 的变量仍是合法
//        的。不过不能用 new Pair<String>[10] 初始化这个变量。


//        可以声明通配类型的数组， 然后进行类型转换:
        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
//        不过，结果将是不安全的。如果在table[0]中存储一个Pair<Employee>, 然后对table[0]. getFirst() 调用一个 String 方法， 会得到一个 ClassCastException 异常。

    }

    @Test
    public void test4() {
        // 不能使用像 new T(...，) newT[...] 或 T.class 这样的表达式中的类型变量。例如， 下面的 Pair<T> 构造器就是非法的:
        // public Pair() { first = new T(); second = new T(); } // Error
    }
}