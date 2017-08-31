package cn.com.sky.basics.test_serializable.normal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 
 * 　只有实现了Serializable和Externalizable接口的类的对象才能被序列化。
 * Externalizable接口继承自 Serializable接口，实现Externalizable接口的类完全由自身来控制序列化的行为，
 * 而仅实现Serializable接口的类可以采用默认的序列化方式 。
 * 
 * 声明为static和transient类型的成员数据不能被序列化。
 * 
 * 
 * 默认在反序列化时不会调用类的任何构造方法。
 * 在对实现了Externalizable接口的类的对象进行反序列化时，会先调用类的不带参数的构造方法，这是有别于默认反序列方式的。
 * 
 * Java的序列化算法 
 * 序列化算法一般会按步骤做如下事情： 
 * 1. 将对象实例相关的类元数据输出。
 * 2. 递归地输出类的超类描述直到不再有超类。
 * 3. 类元数据完了以后，开始从最顶层的超类开始输出对象实例的实际数据值。
 * 4. 从上至下递归输出实例的数据。
 * 
 * </pre>
 */

class parent implements Serializable {
	private static final long serialVersionUID = 1L;
	int parentVersion = 10;
}

class contain implements Serializable {
	private static final long serialVersionUID = 1L;
	int containVersion = 11;
}

public class TestSerializable6 extends parent implements Serializable {
	private static final long serialVersionUID = 1L;
	int version = 66;
	contain con = new contain();

	public int getVersion() {
		return version;
	}

	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerializable6 st = new TestSerializable6();
		oos.writeObject(st);
		oos.flush();
		oos.close();
	}
}
