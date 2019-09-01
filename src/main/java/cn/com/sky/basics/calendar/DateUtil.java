package cn.com.sky.basics.calendar;

import com.google.common.base.Objects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {
        Date d = new Date(1495708208350L);
        System.out.println(d);

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(Objects.equal(System.currentTimeMillis(), new Date().getTime()));

        System.out.println(new Date());
        System.out.println(String.valueOf(new Date()));

        System.out.println(getFormatDateFromLong("" + System.currentTimeMillis()));

    }


    public static String getFormatDateFromLong(String dateLong) {
        if (dateLong == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long time = Long.valueOf(dateLong);
            Date date = new Date();
            date.setTime(time);
            return sdf.format(date);
        } catch (Exception e) {
        }
        return null;
    }

}
