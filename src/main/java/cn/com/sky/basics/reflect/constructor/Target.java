package cn.com.sky.basics.reflect.constructor;

public class Target {
	
	public Target() {
		System.out.println("Target()");
	}


	public Target(String str) {
		System.out.println("Target(String str)");
	}

	public Target(String str, Integer i) {
		System.out.println("Target(String str, Integer i)");
	}

	public Target(String str, int i) {
		System.out.println("Target(String str, int i)");
	}

}
