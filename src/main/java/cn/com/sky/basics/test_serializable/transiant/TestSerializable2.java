package cn.com.sky.basics.test_serializable.transiant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 使用transient关键字不序列化某个变量。
 * 注意:读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致。
 * </pre>
 */
public class TestSerializable2 {

	public static void main(String[] args) {

		User user = new User();
		// user.setName("zhangsan");
		// user.setPwd("123");
		// user.setAge(10);
		//
		// System.out.println("Read before Serializable: ");
		// System.out.println("name: " + user.getName());
		// System.out.println("pwd: " + user.getPwd());
		// System.out.println("age: " + user.getAge());
		// System.out.println("-----------------------------------");
		//
		// try {
		// ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
		// os.writeObject(user); // 将User对象写进文件
		// os.flush();
		// os.close();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("Read after Serializable: ");

			System.out.println("name: " + user.getName());
			 System.out.println("pwd: " + user.getPwd());
			 System.out.println("age: " + user.getAge());
			 System.out.println("height: " + user.getHeight());

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
	private Integer height;

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}