package cn.com.sky.basics.calendar;

import com.google.common.base.Objects;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		Date d = new Date(1495708208350l);
		System.out.println(d);

		Calendar c = Calendar.getInstance();
		
		
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date().getTime());
		System.out.println(Objects.equal(System.currentTimeMillis(),new Date().getTime()));

	}

}
