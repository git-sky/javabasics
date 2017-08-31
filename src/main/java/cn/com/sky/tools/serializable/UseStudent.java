package cn.com.sky.tools.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * <pre>
 * 总结：
 * 1）Java序列化就是把对象转换成字节序列，而Java反序列化就是把字节序列还原成Java对象。
 * 2）采用Java序列化与反序列化技术，一是可以实现数据的持久化，在MVC模式中很是有用；二是可以对象数据的远程通信。
 * 
 *   Java对象的序列化有两种方式。
 *   1.实现序列化接口Serializable
 *   2.实现接口Externalizable
 *   
 *  使用默认的序列化，transient变量和静态变量不会被序列化，如果要对静态成员与transient成员进行序列化时，我们只能通 Externalizable或者是可控的 Serializable来实现。
 * </pre>
 */
public class UseStudent {

	/**
	 * 同一个类对象才可以反序列化
	 */
	@Test
	public void test1() {
		Student st = new Student("Tom", 'M', 20, 3.6);
		File file = new File("e:\\student.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Student对象序列化过程
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(st);
			oos.flush();
			oos.close();
			fos.close();

			// Student对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			cn.com.sky.tools.serializable.demo1.Student st1 = (cn.com.sky.tools.serializable.demo1.Student) ois.readObject();// 报错
			System.out.println("name = " + st1.getName());
			System.out.println("sex = " + st1.getSex());
			System.out.println("age = " + st1.getAge());
			System.out.println("height = " + st1.getHeight());
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * transient变量和静态变量不会被序列化
	 */
	@Test
	public void test2() {
		Student st = new Student("Tom", 'M', 20, 1.8, 55.5, "america");
		File file = new File("e:\\student.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Student对象序列化过程
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(st);
			oos.flush();
			oos.close();
			fos.close();

			System.out.println("name = " + st.getName());
			System.out.println("sex = " + st.getSex());
			System.out.println("age = " + st.getAge());
			System.out.println("height = " + st.getHeight());
			System.out.println("weight = " + st.getWeight());
			System.out.println("nation = " + st.getNation());

			System.out.println("====================");

			// Student对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st1 = (Student) ois.readObject();
			System.out.println("name = " + st1.getName());
			System.out.println("sex = " + st1.getSex());
			System.out.println("age = " + st1.getAge());
			System.out.println("height = " + st1.getHeight());
			System.out.println("weight = " + st1.getWeight());
			System.out.println("nation = " + st1.getNation());

			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}