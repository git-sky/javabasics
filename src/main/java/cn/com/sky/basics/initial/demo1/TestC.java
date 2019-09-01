
package cn.com.sky.basics.initial.demo1;

/**
 * <pre>
 *
 * 类的初始化顺序。
 * 1.先父类和子类的静态初始化(只会初始化一次。)
 * 2.父类实例初始化
 * 3.父类构造方法(如果有多个构造方法，取决于子类调用父类构造方法的方式。默认是使用默认构造方法。)
 * 4.子类实例初始化
 * 5.子类构造方法
 *
 * </pre>
 */
public class TestC {

    F1 f1 = new F1("TestC1");
    F2 f2 = new F2("TestC2");

    public static void main(String[] args) {
        new C();
    }

}