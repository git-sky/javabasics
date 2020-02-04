package cn.com.sky.basics.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * <pre>
 * 【强制】获取当前毫秒数：System.currentTimeMillis(); 而不是new Date().getTime();
 *  说明：如果想获取更加精确的纳秒级时间值，用System.nanoTime。在JDK8中，针对统计时间等场景，推荐使用Instant类.
 *  在开发过程中，通常很多人都习惯使用new Date()来获取当前时间。new Date()所做的事情其实就是调用了System.currentTimeMillis()。
 *  如果仅仅是需要或者毫秒数，那么完全可以使用System.currentTimeMillis()去代替new Date()，效率上会高一点。
 *  如果需要在同一个方法里面多次使用new Date()，通常性能就是这样一点一点地消耗掉。
 *
 * </pre>
 */
public class TestDate {

    @Test
    public void testGetMillis() {

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(System.nanoTime());
    }

    void test1() {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < 2; i++) {

            Date a = new Date(date.getTime());

            System.out.println(a);

            System.out.println(sdf.format(date));

            long beforeTime = (date.getTime() / 1000) + 60 * 5;
            date.setTime(beforeTime * 1000);
            // System.out.println(date.getTime());
            System.out.println(sdf.format(date));

            Date b = new Date(date.getTime());

            // System.out.println(a);
            // System.out.println(b);
            // System.out.println(date.getTime());

            // System.out.println(date.getTime()+String.valueOf(Math.round(Math.random()*899999+100000)));

        }

    }

    void test2() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar c = Calendar.getInstance();

        Date date = new Date();
        System.out.println(sdf.format(date));
        System.out.println(date.getTime());

        long beforeTime = (date.getTime()) - 24 * 60 * 60 * 1000;
        date.setTime(beforeTime);
        System.out.println(date.getTime());
        System.out.println(sdf.format(date));

    }

    void test3() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        try {
            System.out.println(sdf.parse("2013-12-12 22:22:22:999"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void test4() {
        Date d = new Date();
        Date date = new Date();
        long beforeTime = date.getTime() - 1 * 60 * 1000;
        d.setTime(beforeTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(d));
        System.out.println(sdf.format(date));
    }

}
