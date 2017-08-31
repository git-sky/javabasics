package cn.com.sky.basics.test_serializable.readResovle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * <pre>
 * 
 * 通过readResvle方法，返回指定的对象。
 * 
 * 原理： 当从I/O流中读取对象时，readResolve()方法会被调用,用readResolve()中返回的对象直接替换在反序列化过程中创建的对象，而被创建的对象则会被垃圾回收掉。
 * 
 * </pre>
 */
public class TestSerializable2 {

	public static void main(String[] args) {

		User user = new User();
		user.setName("zhangsan");
		user.setPwd("123");
		user.setAge(10);

		System.out.println("Read before Serializable: ");
		System.out.println("name: " + user.getName());
		System.out.println("pwd: " + user.getPwd());
		System.out.println("age: " + user.getAge());
		System.out.println("-----------------------------------");

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("Read after Serializable: ");

			System.out.println("name: " + user.getName());
			System.out.println("pwd: " + user.getPwd());
			System.out.println("age: " + user.getAge());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private transient String pwd;
	private Integer age;

	public User() {
		super();
	}

	public User(String name, String pwd, int age) {
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private Object readResolve() throws ObjectStreamException {
		return new User("lisi", "haha", 33);
	}

}