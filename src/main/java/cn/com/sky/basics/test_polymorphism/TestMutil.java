package cn.com.sky.basics.test_polymorphism;

/**
 * 静态方法是静态绑定。
 * 实例方法是动态绑定。
 */
public class TestMutil {

    public static void main(String[] args) {
        /**
         * test A
         *
         * i am B
         */
        A a = new B();
        test(a);
    }

    public static void test(A a) {
        System.out.println("test A");
        a.print();

    }

    public static void test(B b) {
        System.out.println("test B");
        b.print();
    }

}

class A {
    public void print() {
        System.out.println("i am A");
    }
}

class B extends A {
    public void print() {
        System.out.println("i am B");
    }
}
