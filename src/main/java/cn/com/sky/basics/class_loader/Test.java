package cn.com.sky.basics.class_loader;

public class Test extends ClassLoader {

	public static void main(String[] args) {

		try {
			Class.forName("cn.com.sky.basics.class_loader.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
