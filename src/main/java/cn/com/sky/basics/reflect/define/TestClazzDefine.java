package cn.com.sky.basics.reflect.define;

import org.junit.Test;

public class TestClazzDefine {

    @Test
    public void define() {
        Parent parent = new Parent();
        System.out.println(parent);

        try {
            Class parentClazz = Class.forName("cn.com.sky.basics.reflect.define.Parent");
            System.out.println(parentClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class parentClazz2 = Parent.class;
        Class parentClazz3 = parent.getClass();
        Class intClazz = int.class;
        Class doubleClazz = Double[].class;

        System.out.println(parentClazz2);
        System.out.println(parentClazz3);
        System.out.println(intClazz);
        System.out.println(Integer.class);
        System.out.println(doubleClazz);

    }

    @Test
    public void compare() {

        Parent parent = new Parent();
        Son son = new Son();

        Class parentClazz = null;
        Class sonClazz = null;
        try {
            parentClazz = Class.forName("cn.com.sky.basics.reflect.define.Parent");
            sonClazz = Class.forName("cn.com.sky.basics.reflect.define.Son");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(Parent.class == Parent.class);
        System.out.println(Parent.class == parent.getClass());
        System.out.println(Parent.class == parentClazz);

        System.out.println("====================");


        System.out.println(Son.class == Son.class);
        System.out.println(Son.class == son.getClass());
        System.out.println(Son.class == sonClazz);

        System.out.println("====================");

        System.out.println("parentClazz == sonClazz : " + (parentClazz == sonClazz));

        System.out.println("====================");


        System.out.println("parent instanceof Parent : " + (parent instanceof Parent));

        // 父类不是子类的instance
        System.out.println("parent instanceof Son : " + (parent instanceof Son));

        // 子类是父类的instance
        System.out.println("son instanceof Parent : " + (son instanceof Parent));

        System.out.println("son instanceof Son : " + (son instanceof Son));

    }
}
