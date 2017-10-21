package cn.com.sky.alpha_work;

public class TestA {
	public static void main(String[] args) {

		String path = "/610/599/601/911/607/606/606";

		String[] pathArray = path.split("/");
		for (int i = 1; i < pathArray.length; i++) {
			System.out.println(i + " " + pathArray[i]);
		}

	}

}
