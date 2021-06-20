package cn.com.a_temp;


import cn.com.sky.basics.task.M;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class TestDB {

    @Test
    public void test1() {
        //4库32表
        long userId = 25754850L;
        System.out.println("DB:" + (userId % 4));
        System.out.println("Table:" + ((userId / 4) % 32));
    }

    @Test
    public void test3() {
        //8库16表
        long userId = 7146828713836L;
        System.out.println("DB:" + (userId % 8));
        System.out.println("Table:" + ((userId / 8) % 16));
    }


    @Test
    public void test2() {
        //16库16表
        long userId = 254289895L;
        System.out.println("DB:" + (userId % 16));
        System.out.println("Table:" + ((userId / 16) % 16));
    }

}