package cn.com.sky.alpha_work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {

    public static void main(String[] args) {
//        System.out.println(new Date(1528276815814L));

        SimpleDateFormat simpleDateFormat=new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(simpleDateFormat.format(new Date(1528276815814L)));
    }
}
