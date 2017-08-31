package cn.com.sky.basics.test_serializable.statics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * <pre>
 * 2. transient使用小结
 * 
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，
 * 则该类需要实现Serializable接口。
 * 
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 * 
 * 第三点可能有些人很迷惑，因为发现在User类中的username字段前加上static关键字后，程序运行结果依然不变，
 * 即static类型的username也读出来为
 * “Alexia”了，这不与第三点说的矛盾吗？实际上是这样的：第三点确实没错（一个静态变量不管是否被transient修饰
 * ，均不能被序列化），反序列化后类中static型变量username的值为当前JVM中对应static变量的值
 * ，这个值是JVM中的不是反序列化得出的，不相信？好吧，下面我来证明：
 *
 * </pre>
 */
public class TestSerializable4 {

	public static void main(String[] args) {

		Users user = new Users();
		user.setName("zhangsan");
		user.setPwd("123456");
		user.setAge(10);

		System.out.println("read before Serializable: ");
		System.out.println("name: " + user.getName());
		System.out.println("pwd: " + user.getPwd());
		System.out.println("age: " + user.getAge());
		System.out.println("----------------------------------------");

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
			// 在反序列化之前改变name的值
			Users.name = "lisi";

			ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
			user = (Users) is.readObject(); // 从流中读取User的数据
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

class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	public static String name;
	private transient String pwd;
	private Integer age;

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

}