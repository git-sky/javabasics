package cn.com.sky.basics.generics;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person(101);
		p1.setSsecrecy("芝麻开门");
		String s = (String) p1.getSecrecy();
		System.out.println(p1.getId() + "\t密码是:" + s);

		Person<Double> p2 = new Person<Double>(102);
		p2.setSsecrecy(8700.45);
		double money = p2.getSecrecy();
		System.out.println(p2.getId() + "\t秘密资金数额:" + money);
		
	}

	private static final class Person<a> {

		private final int id;
		private a secrecy;

		public Person(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setSsecrecy(a secrecy) {
			this.secrecy = secrecy;
		}

		public a getSecrecy() {
			return secrecy;
		}
	}

}
