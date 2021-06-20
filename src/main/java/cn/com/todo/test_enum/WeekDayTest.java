package cn.com.todo.test_enum;
public class WeekDayTest {

	public static void main(String args[]) {

		for (WeekDay day : WeekDay.values()) {

			System.out.println(day + "====>" + day.getDay());
		}

		WeekDay.printDay(5);

	}

}
