package cn.com.sky.setget;

public class TestConfig {

	public static void main(String[] args) {

		new TestConfig().say();
		;
	}

	public void say() {
		RebateConfig rc = new RebateConfig();
		rc.dynamicChangeConfig("rebateInteger", "23");
		rc.dynamicChangeConfig("rebateBoolean", "true");
		rc.dynamicChangeConfig("rebateString", "abcd");

		System.out.println(rc.getRebateInteger());
		System.out.println(rc.getRebateBoolean());
		System.out.println(rc.getRebateString());
	}

}
