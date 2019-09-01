package cn.com.sky.basics.enums;

import org.apache.commons.lang.StringUtils;

public enum WeekDay {

    Mon("Monday"), Tue("Tuesday"), Wed("Wednesday"), Thu("Thursday"), Fri("Friday"), Sat("Saturday"), Sun("Sunday");

    private final String day;

    private WeekDay(String day) {
        this.day = day;
    }

    public static WeekDay get(String day) {
        for (WeekDay wk : WeekDay.values()) {
            System.out.println("wk=" + wk);
            if (StringUtils.equalsIgnoreCase(wk.getDay(), day)) {
                return wk;
            }
        }
        return null;
    }

    public static void printDay(int i) {

        switch (i) {

            case 1:
                System.out.println(WeekDay.Mon);
                break;

            case 2:
                System.out.println(WeekDay.Tue);
                break;

            case 3:
                System.out.println(WeekDay.Wed);
                break;

            case 4:
                System.out.println(WeekDay.Thu);
                break;

            case 5:
                System.out.println(WeekDay.Fri);
                break;

            case 6:
                System.out.println(WeekDay.Sat);
                break;

            case 7:
                System.out.println(WeekDay.Sun);
                break;

            default:
                System.out.println("wrong number!");

        }

    }

    public String getDay() {
        return day;
    }

}
