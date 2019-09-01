package cn.com.sky.basics.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestCalendar3 {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void test1() {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, 24);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        int ahour = c.get(Calendar.HOUR_OF_DAY); // 24小时制

        System.out.println(ahour);


        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH); // ��ȡ��ǰ����
        int first = c.getActualMinimum(Calendar.DAY_OF_MONTH); // ��ȡ������С����
        int last = c.getActualMaximum(Calendar.DAY_OF_MONTH); // ��ȡ�����������
        int hour = c.get(Calendar.HOUR_OF_DAY); // 24小时制
        int min = c.get(Calendar.MINUTE); // ��ȡ��ǰ����
        int sec = c.get(Calendar.SECOND); // ��ȡ��ǰ��

        System.out.println(c.get(Calendar.HOUR));

        System.out.println("now:" + year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);

        int dayY = c.get(Calendar.DAY_OF_YEAR); // ����ڼ���
        System.out.println(dayY);

        int dayW = c.get(Calendar.DAY_OF_WEEK); // ���ܵĵڼ��죨����-���� ��1-7��
        System.out.println(dayW);

        int dayM = c.get(Calendar.DAY_OF_MONTH); // ���µĵڼ���
        System.out.println(dayM);

        int dayD = c.get(Calendar.DATE); // ���µĵڼ���
        System.out.println(dayD);

        System.out.println("��ǰʱ�䣺" + year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);

        System.out.println("��һ�������죺" + first + "," + last + "," + day);

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = s.format(c.getTime()); // ��ǰ����
        System.out.println("��ǰ����curDate====��" + curDate);

        // ����ʱ��
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH) + 1;
        int day2 = c.get(Calendar.DAY_OF_MONTH);
        int firstD = c.getActualMinimum(Calendar.DAY_OF_MONTH);
        int lastD = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("��ǰʱ�䣺" + year2 + "-" + month2 + "-" + day2 + " " + hour + ":" + min + ":" + sec);
        System.out.println("��һ�������죺" + firstD + "," + lastD);

    }

    @Test
    public void test2() {
        long dayMilliseconds = 24 * 3600 * 1000;
        Calendar now = Calendar.getInstance();

        Date runtime1 = now.getTime();
        System.out.println(runtime1);

        now.set(Calendar.DAY_OF_YEAR, now.get(Calendar.DAY_OF_YEAR));
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        Date runtime = now.getTime();

        System.out.println(runtime);
    }

    void test3() {

        Date begin = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            begin = dateFormat.parse("2013-07-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(begin);
        Calendar c = Calendar.getInstance();
        c.setTime(begin);
        for (int i = 0; i < 10; i++) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String a = dateFormat.format(c.getTime());
            System.out.println(a);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    void test4() {

        Calendar c = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date begin = null;
        try {
            begin = dateFormat.parse("20130201");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String a = "";
        c.setTime(begin);

        c.add(Calendar.YEAR, -1);
        a = dateFormat.format(c.getTime());
        System.out.println(a);

        c.add(Calendar.YEAR, 2);
        a = dateFormat.format(c.getTime());
        System.out.println(a);

    }

    void test5() {

        Calendar c = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = c.getTime();

        String times = sdf.format(d);

        times = times.replace(" ", "T");

        System.out.println(times);
    }

    void test6() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < 100; i++) {
            c.add(Calendar.DAY_OF_MONTH, -1);
            Date d = c.getTime();
            String times = sdf.format(d);
            System.out.println(times);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

    }

    void test7() {

        SimpleDateFormat sdf = new SimpleDateFormat("yy-M-d");

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

        String playtime = "14-1-7";

        Date d = null;

        try {
            d = sdf.parse(playtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(d.toLocaleString());

        System.out.println(sdf2.format(d));

    }

    @Test
    public void test8() {

        Calendar now = Calendar.getInstance();

        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);

        System.out.println(now.getTime());
    }

}