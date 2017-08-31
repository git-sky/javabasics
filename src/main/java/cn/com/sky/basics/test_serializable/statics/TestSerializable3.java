package cn.com.sky.basics.test_serializable.statics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerializable3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Foo foo = new Foo();
		System.out.printf("w: %d%n", Foo.w);
		System.out.printf("x: %d%n", Foo.x);
		System.out.printf("y: %d%n", foo.y);
		System.out.printf("z: %d%n", foo.z);

		FileOutputStream fos = new FileOutputStream("x.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(foo);
		oos.close();

		foo = null;

		FileInputStream fis = new FileInputStream("x.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println();
		foo = (Foo) ois.readObject();
		ois.close();
		System.out.printf("w: %d%n", Foo.w);
		System.out.printf("x: %d%n", Foo.x);
		System.out.printf("y: %d%n", foo.y);
		System.out.printf("z: %d%n", foo.z);
	}
}

class Foo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static int w = 1;
	public static transient int x = 2;
	public int y = 3;
	public transient int z = 4;
}