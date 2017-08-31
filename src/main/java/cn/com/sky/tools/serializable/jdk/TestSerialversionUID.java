package cn.com.sky.tools.serializable.jdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 
 * serialVersionUID的取值是Java运行时环境根据类的内部细节自动生成的。如果对类的源代码作了修改，再重新编译，
 * 新生成的类文件的serialVersionUID的取值有可能也会发生变化。
 * 类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，用不同的Java编译器编译，有可能会导致不同的serialVersionUID，也有可能相同。
 * 为了提高serialVersionUID的独立性和确定性，强烈建议在一个可序列化类中显示的定义serialVersionUID，为它赋予明确的值。
 * 
 * 显式地定义serialVersionUID有两种用途：
 * 1、 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
 * 2、 在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
 * 
 */
public class TestSerialversionUID {

	private static final String FILE_NAME = "e:/test.txt";

	public static void main(String[] args) throws Exception {
		SerializeCustomer();// 序列化Customer对象
		Customer customer = DeserializeCustomer();// 反序列Customer对象
		System.out.println(customer);
	}

	/**
	 * 序列化Customer对象
	 */
	private static void SerializeCustomer() throws FileNotFoundException, IOException {
		Customer customer = new Customer("abc", 25);
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)));
		oo.writeObject(customer);
		System.out.println("Customer对象序列化成功！");
		System.out.println(customer);
		oo.close();
	}

	/**
	 * 反序列Customer对象
	 */
	private static Customer DeserializeCustomer() throws Exception, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FILE_NAME)));
		Customer customer = (Customer) ois.readObject();
		System.out.println("Customer对象反序列化成功！");
		System.out.println(customer);
		ois.close();
		return customer;
	}
}

class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	/**
	 * 
	 */
	// Customer类中没有定义serialVersionUID
	private String name;
	private int age;

	private int height = 0;
	private int a = 0;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

}