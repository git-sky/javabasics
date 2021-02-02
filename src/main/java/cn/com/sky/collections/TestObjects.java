package cn.com.sky.collections;


import cn.com.sky.alpha_work.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestObjects {

    @Test
    public void testEquals() {
        System.out.println(Objects.equals(123456, 123456));//true
        System.out.println(Objects.equals(123456, 123456L));//false

        /**
         * Integer重写了equals方法。
         */
        System.out.println(Objects.equals(new Integer(123456), new Integer(123456)));//true
        System.out.println(Objects.equals(new Long(123456), new Long(123456)));//true
        System.out.println(Objects.equals(new Long(123456), new Integer(123456)));//false


        System.out.println("Objects.equals(new User(), new User())= " + Objects.equals(new User(), new User()));//false
        System.out.println("Objects.deepEquals(new User(), new User())= " + Objects.deepEquals(new User(), new User()));//false

        List<Integer> list = new ArrayList();
        System.out.println(Objects.equals(list, list));//true
        System.out.println(Objects.deepEquals(list, list));//true

        List<Integer> blist = new ArrayList();
        System.out.println(Objects.equals(list, blist));//true
        System.out.println(Objects.deepEquals(list, blist));//true

    }
}
