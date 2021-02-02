package cn.com.sky.basics.test_create_object;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

/**
 * 通过反射机制创建对象实例
 */
public class TestReflect {

    @Test
    public void test() {
        // 1 通过 Class.forName 创建对象实例
        Class<?> clazz = null;
        try {
            clazz = Class.forName("cn.com.sky.basics.test_create_object.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = null; // 会调用User类的默认构造方法
        try {
            user = (User) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        user.say();
    }

    @Test
    public void test1() {
        // 1 通过 Class.forName 创建对象实例
        System.out.println(User.class.getName());
        Class<?> clazz = null;
        try {
            clazz = Class.forName(User.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = null; // 会调用User类的默认构造方法
        try {
            user = (User) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        user.say();
    }

    @Test
    public void test2() {
        // 2 通过 class 的 newInstance 创建对象实例
        User user2 = null;// 会调用User类的默认构造方法
        try {
            user2 = User.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(user2);
    }

    @Test
    public void test3() {
        // 3 通过 constructor 的 newInstance 创建对象实例
        Constructor<User> constructor = null;
        try {
            constructor = User.class.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        User user3 = null;
        try {
            user3 = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user3);
    }

    @Test
    public void test4() {
        // 4 通过 constructor 的有参构造方法 newInstance 创建对象实例
        Class<?> clazz = null;
        try {
            clazz = Class.forName(User.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class[] paramTypes = {String.class, Integer.class};
        Constructor constructor = null;
        try {
            constructor = clazz.getConstructor(paramTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        User user4 = null;
        try {
            user4 = (User) constructor.newInstance("zhangsan", 123);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user4);
    }

    @Test
    public void test5() {
        // 通过 constructor 的有参构造方法 newInstance 创建对象实例
        Class<?> clazz = null;
        try {
            clazz = Class.forName(User.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        constructor.setAccessible(true);
        User user5 = null;
        try {
            user5 = (User) constructor.newInstance("zhangsan");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user5);
    }

}
