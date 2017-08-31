package cn.com.sky.collections.map;

import java.util.EnumMap;

import org.junit.Test;

import cn.com.sky.basics.enums.WeekDay;

public class TestEnumMap {
	@Test
	public void test() {
		new EnumMap<>(WeekDay.class);
	}
}
