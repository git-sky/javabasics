package cn.com.sky.basics.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCal {

	public static void main(String args[]) {

////		long l = Calendar.getInstance().getTimeInMillis();
		long l=1474611652242L;
		System.out.println(l);
		Date d = new Date(l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		System.out.println(d.getTime());
		
		
//		System.out.println( Integer.valueOf("c00", 16));

	}
}
