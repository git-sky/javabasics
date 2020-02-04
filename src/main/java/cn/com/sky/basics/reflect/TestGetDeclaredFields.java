package cn.com.sky.basics.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestGetDeclaredFields {

    private String str1;
    private static final String str2 = "str";
    public static final String str3 = "str3";


    @Test
    public void test() {

        // getDeclaredFields 获取当前类的全部域
        Field[] fields = TestGetDeclaredFields.class.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("============================");
            System.out.println("字段" + f.getName() + "访问修饰符是否包括 private:" + Modifier.isPrivate(f.getModifiers()));
            System.out.println("字段" + f.getName() + "访问修饰符是否包括 static:" + Modifier.isStatic(f.getModifiers()));
            System.out.println("字段" + f.getName() + "访问修饰符是否包括 public:" + Modifier.isPublic(f.getModifiers()));

            System.out.println("字段" + f.getName() + "访问修饰符是否包括 final:" + Modifier.isFinal(f.getModifiers()));
        }
    }

}