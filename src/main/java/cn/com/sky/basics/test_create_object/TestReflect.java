package cn.com.sky.basics.test_create_object;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

//通过反射机制创建对象  
@SuppressWarnings("rawtypes")
public class TestReflect {

    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1
        Class<?> clazz = Class.forName("cn.com.sky.basics.test_create_object.User");
        User user = (User) clazz.newInstance(); // 会调用User类的默认构造方法
        System.out.println(user);
        user.say();
    }

    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1
        System.out.println(User.class.getName());
        Class<?> clazz = Class.forName(User.class.getName());
        User user = (User) clazz.newInstance(); // 会调用User类的默认构造方法
        System.out.println(user);
        user.say();
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        // 2
        User user2 = User.class.newInstance();// 会调用User类的默认构造方法
        System.out.println(user2);
    }

    @Test
    public void test3() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 3
        Constructor<User> constructor = User.class.getConstructor();
        User user3 = constructor.newInstance();
        System.out.println(user3);
    }

    @Test
    public void test4() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        // 4
        Class<?> clazz = Class.forName(User.class.getName());
        Class[] paramTypes = {String.class, Integer.class};
        Constructor constructor = clazz.getConstructor(paramTypes);
        User user4 = (User) constructor.newInstance("zhangsan", 123);
        System.out.println(user4);
    }

    @Test
    public void test5() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        // 5
        Class<?> clazz = Class.forName(User.class.getName());
        Constructor cons5 = clazz.getDeclaredConstructor(String.class);
        cons5.setAccessible(true);
        User user5 = (User) cons5.newInstance("zhangsan");
        System.out.println(user5);
    }

}
