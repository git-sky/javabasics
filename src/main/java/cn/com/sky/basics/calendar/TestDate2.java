package cn.com.sky.basics.calendar;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate2 {

    public static void main(String args[]) {

        long l = 1474611652242L;
        System.out.println(l);
        Date d = new Date(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
        System.out.println(d.getTime());

        System.out.println(null instanceof Exception);

    }

    @Test
    public void test() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1556099810000L)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1556099810000L));
    }
}
