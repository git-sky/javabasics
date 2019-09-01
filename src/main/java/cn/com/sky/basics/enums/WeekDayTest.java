package cn.com.sky.basics.enums;

public class WeekDayTest {

    public static void main(String args[]) {

        for (WeekDay day : WeekDay.values()) {
            System.out.println(day + "====>" + day.getDay());
        }

        WeekDay.printDay(5);

        WeekDay wk = WeekDay.get("Wednesday");
        System.out.println("wk=" + wk);
        System.out.println("day=" + wk.getDay());


        System.out.println(WeekDay.valueOf("Wed"));


    }

}
