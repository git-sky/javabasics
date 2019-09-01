package cn.com.sky.basics.reflect.constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

/***
 * getDeclaredConstructor(cls)：返回指定参数类型、所有声明的（包括private）构造函数
 */
public class TestGetDeclaredConstructor {

    @Test
    public void test1() {
        try {
            Class cls[] = new Class[]{String.class};
            Constructor c = String.class.getDeclaredConstructor(cls);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        try {
            // 获取指定的构造方法
            Constructor c = User.class.getDeclaredConstructor();
            System.out.println(c);
            //实例化
            User target = (User) c.newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test3() {
        try {
            Class cls[] = new Class[]{String.class, Integer.class};
            // 获取指定的构造方法
            Constructor c = User.class.getDeclaredConstructor(cls);
            System.out.println(c);
            //实例化
            User target = (User) c.newInstance("abc", 123);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void test4() {
        try {
            Class cls[] = new Class[]{String.class, String.class};
            // 获取指定的构造方法
            Constructor c = User.class.getDeclaredConstructor(cls);
            System.out.println(c);
            //实例化
            User target = (User) c.newInstance(" ", "bcd");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}