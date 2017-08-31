package cn.com.sky.basics;

public class TestThisSon extends TestThis {

	public static void main(String[] args) {
		TestThisSon obj = new TestThisSon();
		System.out.println(obj.toString());
		obj.print();
	}

	public TestThisSon() {
		System.out.println(this.toString());
	}

}
