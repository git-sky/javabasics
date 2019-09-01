package cn.com.sky.basics.test_serializable.readResovle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class TestReadResolve {

	public static void main(String[] args) throws Exception {
		File file = new File("person.out");
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(Person.getInstance()); // 保存单例对象
		oout.close();

		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject();
		oin.close();
		System.out.println(newPerson);

		System.out.println(Person.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
	}
}

// 每个枚举类型都会默认继承类java.lang.Enum，而该类实现了Serializable接口，所以枚举类型对象都是默认可以被序列化的。
enum Gender {
	MALE, FEMALE
}

/**
 * <pre>
 * 
 * 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
 *
 * 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象，而被创建的对象则会被垃圾回收掉。
 * 
 * </pre>
 */
class Person implements Serializable {

	private static class InstanceHolder {
		private static final Person instatnce = new Person("John", 31, Gender.MALE);
	}

	public static Person getInstance() {
		return InstanceHolder.instatnce;
	}

	private static final long serialVersionUID = 3788305009433902592L;

	private String name = null;
	private transient Integer age = null;
	private Gender gender = null;

	private Person() {
		System.out.println("none-arg constructor");
	}

	private Person(String name, Integer age, Gender gender) {
		System.out.println("arg constructor");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + age + ", " + gender + "]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		// out.defaultWriteObject();// defaultWriteObject()方法，该方法会执行默认的序列化机制。
		// out.writeInt(age);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// in.defaultReadObject();
		// age = in.readInt();
	}

	private Object readResolve() throws ObjectStreamException {
		return getInstance();
	}

}