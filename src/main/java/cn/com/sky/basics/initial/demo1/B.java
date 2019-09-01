package cn.com.sky.basics.initial.demo1;

public class B extends A {
    int c = 2;

    static {
        System.out.println("static in B..1");
    }

    public static A a = new A();


    F1 f1 = new F1("b1");

    static {
        System.out.println("static in B..2");
    }

    public B() {
        System.out.println("B...");
        //show(); //会调用子类的show方法，因为此时子类的变量尚未初始化，所以输出为0.
    }

    F2 f2 = new F2("b2");

    static {
        System.out.println("static in B..3");
    }

    public void show() {
        System.out.println("B...show()");
        System.out.println(c);
    }

    static {
        System.out.println("static in B..4");
    }

    public static void main(String[] args) {
        new B();
        //B b=new C();
        //b.show();
    }

}
