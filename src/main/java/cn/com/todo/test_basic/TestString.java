package cn.com.todo.test_basic;

public class TestString {

	public static void main(String args[]) {

		TestString ts = new TestString();

		ts.testCompareTo();
		ts.test2();
	}

	// ���ֵ�˳��Ƚ������ַ������ñȽϻ����ַ����и����ַ��� Unicode ֵ������ String
	// �����ʾ���ַ�����������ַ�������ʾ���ַ����н��бȽϡ�������ֵ�˳��� String
	// �����ڲ����ַ���֮ǰ����ȽϽ��Ϊһ����������������ֵ�˳��� String
	// ����λ�ڲ����ַ���֮����ȽϽ��Ϊһ��������������������ַ�����ȣ�����Ϊ 0��compareTo ֻ���ڷ��� equals(Object)
	// ���� true ʱ�ŷ��� 0��
	void testCompareTo() {
		String now = "20130911";
		String end = "20130915";
		if (now.compareTo(end) < 0) {
			System.out.println(end);
			System.out.println(now);
			end = now;
		}
		System.out.println(end);
		System.out.println(now);
	}

	void test2() {
		String sch = "";
		StringBuffer all_schedule = new StringBuffer();
		all_schedule.append("31");
		all_schedule.append("-");
		all_schedule.append("23");
		all_schedule.append("-");
		if (all_schedule.length() > 0) {
			sch = all_schedule.substring(0, all_schedule.length() - 1);
		}
		System.out.println(sch);
	}

}
