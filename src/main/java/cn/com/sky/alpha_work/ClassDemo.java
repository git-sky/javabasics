package cn.com.sky.alpha_work;

class A {
    void aa() {
        System.out.println("A里的");

    }

}

class B extends A {
    void aa() {
        System.out.println("B里的");

    }

}

class C extends A {
    void aa() {
        System.out.println("C里的");

    }

}

public class ClassDemo {

    public static void main(String[] args) {
        ClassDemo t = new ClassDemo();
        t.show("C");
    }

    void show(String name) {
        try {
            A show = (A) Class.forName(name).newInstance();
            show.aa();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}