package cn.com.sky.basics.compare;

public class TestComparable implements Comparable<TestComparable> {

	public TestComparable(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	private int a;
	private int b;

	@Override
	public int compareTo(TestComparable o) {
		return (this.a > o.a || this.b > o.b) ? 1 : 0;
	}

	public static void main(String[] args) {

		TestComparable t1 = new TestComparable(1, 1);
		TestComparable t2 = new TestComparable(2, 3);

		System.out.println(t1.compareTo(t2));
	}
}
