package cn.com.sky.tools.serializable.jdk;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * <pre>
 * 
 * Serializable 对象完全以它存储的二进制位为基础重组，反序列化时不会调用构造函数，哪怕是默认构造函数 。
 * 而对一个 Externalizable 对象，反序列化时缺省构造函数先会被调用 ，然后调用 readExternal()。
 * 
 * 实现 Externalizable接口步骤 如下：
 * 1 、实现 Externalizable 接口
 * 2 、实现 writeExternal() ，在方法中指明序列化哪些对象，如果不存储则不能保存某属性状态
 * 3 、 实现 readExternal() ，在方法中指明反序列化哪些对象，如果不读取则不能恢复某属性状态
 * 
 * 
 * Externalizable 恢复一个对象状态过程如下：
 * 1 、调用对象的缺省构造函数 ( 注：缺省构造函数一定要是 public 的 ，其他都不行，否在反序列化时出错 )
 * 2 、通过 readExternal() 对各个属性进行进一步的恢复
 * 
 */
public class TestExternalizable implements Externalizable {

	private String name;
	private int age;

	// Externalizable反序列化时会先调用.
	public TestExternalizable() {
		System.out.println("TestExternalizable()");
	}

	public TestExternalizable(String name, int age) {
		System.out.println("TestExternalizable(String name, int age)");
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestExternalizable [name=" + name + ", age=" + age + "]";
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal(ObjectOutput out)");
		// 序列化时你必须这样做，你不能((ObjectOutputStream) out).defaultWriteObject();
		out.writeObject(name);
		out.writeInt(age);

	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal(ObjectInput in)");
		// 反序列化时你必须这样做，你不能((ObjectInputStream) in).defaultReadObject();
		name = (String) in.readObject();
		age = in.readInt();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		final String fileName = "e:/test.txt";

		TestExternalizable a = new TestExternalizable("abc", 13);
		System.out.println(a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
		System.out.println("Saving object:");
		o.writeObject(a);
		o.close();

		TestExternalizable b = null;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		System.out.println("Recovering object:");
		b = (TestExternalizable) in.readObject();
		in.close();
		System.out.println(b);

	}
}