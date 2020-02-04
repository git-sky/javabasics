package cn.com.sky.basics.class_loader;

public class A {

    //类加载的时候执行
    static {
        System.out.println("static");
    }

    //实例化的时候先执行这个,在构造方法之前。
    {
        System.out.println("normal");
    }

    public A() {
        System.out.println("new A()");
    }

}
