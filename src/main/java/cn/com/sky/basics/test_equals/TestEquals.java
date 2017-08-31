package cn.com.sky.basics.test_equals;

public class TestEquals {

	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		String d = new String("abc");

		System.out.println((a == b) + "," + a.equals(b));
		System.out.println((b == c) + "," + b.equals(c));
		System.out.println((a == c) + "," + a.equals(c));
		System.out.println((d == c) + "," + d.equals(c));

		System.out.println(a + "," + b);
		testString(a, b);
		System.out.println(a + "," + b);

		Integer ia = new Integer("1");
		Integer ib = new Integer("2");
		testInteger(ia, ib);
		System.out.println(ia + "," + ib);

		Persion pa = new Persion(1, 1);
		Persion pb = new Persion(2, 2);
		testPersion(pa, pb);
		System.out.println(pa + "," + pb);

		testPersion2(pa, pb);
		System.out.println(pa + "," + pb);
	}

	public static void testString(String a, String b) {
		// a = new String("124");
		b = new String("333");
		a = "1244";
		System.out.println(b);
		System.out.println(a);
	}

	public static void testInteger(Integer ia, Integer ib) {
		ia = 11;
		ib = 22;
		System.out.println(ia);
		System.out.println(ib);

	}

	public static void testPersion(Persion pa, Persion pb) {
		pa = new Persion(4, 4);
		pb = new Persion(3, 3);
		System.out.println(pa);
		System.out.println(pb);
	}

	public static void testPersion2(Persion pa, Persion pb) {
		pa.age = 12334;
		pb.height = 333;
	}

}

class Persion {
	public int age = 12;
	public int height = 180;

	Persion(int age, int height) {
		this.age = age;
		this.height = height;
	}

	public String toString() {
		return age + "," + height;
	}

}