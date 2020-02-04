package cn.com.sky.basics.reflect;


import org.junit.Test;

import java.lang.reflect.Field;

public class TestReflect2 {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        TestReflect testReflect = new TestReflect();
        Field field3 = testReflect.getClass().getDeclaredField("age");
        field3.setAccessible(true);
//            field3.set(this, 45);

        System.out.println("field3.get=" + field3.get(testReflect));
    }
}