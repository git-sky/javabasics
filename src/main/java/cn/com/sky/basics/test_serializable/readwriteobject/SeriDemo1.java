package cn.com.sky.basics.test_serializable.readwriteobject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * 
 * 以下情况需要自定义序列化的方式： 
 * 
 * 1.为了确保序列化的安全性，可以对于一些敏感信息加密；
 * 2.确保对象的成员变量符合正确的约束条件；
 * 3.确保需要优化序列化的性能。
 */
public class SeriDemo1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	transient private String password;

	// 瞬态，不可序列化状态，该字段的生命周期仅存于调用者的内存中
	public SeriDemo1() {
	}

	public SeriDemo1(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// 模拟对密码进行加密
	private String change(String password) {
		return password + "minna";
	}

	// 写入
	private void writeObject(ObjectOutputStream outStream) throws IOException {
		outStream.defaultWriteObject();
		outStream.writeObject(change(password));
	}

	// 读取
	private void readObject(ObjectInputStream inStream) throws IOException, ClassNotFoundException {
		inStream.defaultReadObject();
		String strPassowrd = (String) inStream.readObject();
		// 模拟对密码解密
		password = strPassowrd.substring(0, strPassowrd.length() - 5);
	}

	// 返回一个“以文本方式表示”此对象的字符串
	public String toString() {
		return "SeriDemo1 [name=" + name + ", password=" + password + "]";
	}

	// 静态的main
	public static void main(String[] args) throws Exception {
		SeriDemo1 demo = new SeriDemo1("haom", "0123");
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(buf);
		out.writeObject(demo);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		demo = (SeriDemo1) in.readObject();
		System.out.println(demo);
	}
}