package cn.com.sky.lamda.supplier;


import org.apache.commons.lang3.RandomUtils;

public class MyStudent {

    public MyStudent() {
        System.out.println("MyStudent() " + RandomUtils.nextInt());
    }
}