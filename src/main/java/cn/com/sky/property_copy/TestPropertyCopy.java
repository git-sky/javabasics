package cn.com.sky.property_copy;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

public class TestPropertyCopy {

    @Test
    public void test1() {
//		 Person src = new Person("张三", "男", 22);

        Person2 src = new Person2("张三", "男", "33");

        People dest = new People();

        try {
            //属性拷贝，类型不匹配，则报错。
            PropertyUtils.copyProperties(dest, src);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(src);
        System.out.println(dest);
    }

    @Test
    public void test2() {

//		Person src = new Person("李四", "女", 55);

        Person2 src = new Person2("张三", "男", "66");


        People dest = new People();

        try {
            //属性拷贝，类型不匹配，也可以拷贝成功。
            //Apache的BeanUtils的性能最差，无论是单次Copy还是大数量的多次Copy性能都不是很好。
            BeanUtils.copyProperties(dest, src);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(src);
        System.out.println(dest);

    }

}
