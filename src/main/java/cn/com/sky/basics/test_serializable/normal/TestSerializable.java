package cn.com.sky.basics.test_serializable.normal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 
 * 序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化,将数据分解成字节流，以便存储在文件中或在网络上传输。
 *
 * 可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。
 *
 * 序列化是为了解决在对对象流进行读写操作时所引发的问题。
 * 
 * </pre>
 */
public class TestSerializable implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name = "zhangsan";
	public int age = 123;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerializable ts = new TestSerializable();
		oos.writeObject(ts);
		oos.flush();
		oos.close();

		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TestSerializable tso = (TestSerializable) ois.readObject();
		ois.close();

		System.out.println("name=" + tso.name);
		System.out.println("age=" + tso.age);

	}
}
