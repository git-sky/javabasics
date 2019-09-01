package cn.com.sky.collections.set;

import java.util.EnumSet;

import org.junit.Test;

public class TestEnumSet {

    enum WeekDay {
        MONDAY, TUESDAY, WEDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    @Test
    public void test() {

        EnumSet<WeekDay> always = EnumSet.allOf(WeekDay.class);
        EnumSet<WeekDay> never = EnumSet.noneOf(WeekDay.class);

        System.out.println(always.size());
        System.out.println(never.size());

    }
}
