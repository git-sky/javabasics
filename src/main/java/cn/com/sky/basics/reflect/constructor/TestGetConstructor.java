package cn.com.sky.basics.reflect.constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * getConstructor(cls)：返回指定参数类型、具有public访问权限的构造函数
 */
public class TestGetConstructor {

    @Test
    public void test1() {
        try {
            Class cls[] = new Class[]{String.class};
            Constructor c = String.class.getConstructor(cls);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        try {
            Class cls[] = new Class[]{String.class, Integer.class};
            // 获取指定的构造方法
            Constructor c = Target.class.getConstructor(cls);
            System.out.println(c);
            //实例化
            Target target = (Target) c.newInstance("abc", 123);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test3() {
        try {
            // 获取指定的构造方法
            Constructor c = Target.class.getConstructor();
            System.out.println(c);
            //实例化
            Target target = (Target) c.newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test4() {
        try {
            Class cls[] = new Class[]{String.class, String.class};
            // 获取指定的构造方法
            Constructor c = Target.class.getConstructor(cls);
            System.out.println(c);
            //实例化
            Target target = (Target) c.newInstance("abc", "bcd");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}