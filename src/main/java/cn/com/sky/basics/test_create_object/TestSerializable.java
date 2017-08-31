package cn.com.sky.basics.test_create_object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <pre>
 * 
 * 通过反序列化创建User对象。
 * 
 * 在反序列化时，jvm创建对象并不会调用任何构造函数。
 * 
 */
public class TestSerializable {

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		User user = new User("zhangsan", 12);
		System.out.println(user);

		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.flush();
		oos.close();

		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User user2 = (User) ois.readObject();// 从文件中还原类的对象,不会调用构造函数
		ois.close();

		System.out.println(user2);

	}
}
