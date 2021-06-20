package cn.com.todo.test_datecalendar;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestCalendar {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {

		TestCalendar tc = new TestCalendar();

		Date dd = new Date();

		 tc.cal2date(dd);
		 tc.date2cal();

		tc.parse("2012-06-04");
		tc.test2();

	}

	/**
	 * Calendar ---> Date
	 */
	void date2cal() {

		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 5; i++) {
			cal.add(Calendar.DATE, -1);
			Date d = cal.getTime();// ��һ�� Calendar �����л�ȡ Date ����
			System.out.println(sdf.format(d));
		}
	}

	/**
	 * Date ---> Calendar
	 */
	void cal2date(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		for (int i = 0; i < 5; i++) {
			System.out.println(sdf.format(cal.getTime()));
			// ��add()�������������ַ�ʽ��һ����
			cal.add(Calendar.DATE, -2);
			// cal.add(Calendar.DAY_OF_MONTH, -2);
			// cal.add(Calendar.DAY_OF_YEAR, -2);
			// cal.add(Calendar.DAY_OF_WEEK, -2);
			System.out.println(sdf.format(cal.getTime()));
		}
	}

	void parse(String date) {

		System.out.println(date);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;

		try {
			d = sdf.parse(date);// SimpleDateFormat����parse()�������ڽ�������ض��ַ���ת����Date��Ķ���
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(d);

		String[] dates = new String[3];

		cal.setTime(d);
		for (int i = 0; i <= 2; i++) {
			dates[i] = sdf.format(cal.getTime());
			cal.add(Calendar.DATE, -1);
		}

		for (int i = 0; i <= 2; i++) {
			System.out.println(dates[i]);

		}
	}

	void test2() {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(c);
	}
}