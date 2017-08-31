package cn.com.sky.basics.test_serializable.readwriteobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestReadWriteObject {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 101, Gender.MALE);
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = ois.readObject(); // 没有强制转换到Person类型
        ois.close();
        System.out.println(newPerson);
    }
}


//每个枚举类型都会默认继承类java.lang.Enum，而该类实现了Serializable接口，所以枚举类型对象都是默认可以被序列化的。
enum Gender {
	MALE, FEMALE
}


/**
 * <pre>
 * 
 *  默认序列化机制
 *  
 *  如果仅仅只是让某个类实现Serializable接口，而没有其它任何处理的话，则就是使用默认序列化机制。
 *  使用默认机制，在序列化对象时，不仅会序列化当前对象本身，还会对该对象引用的其它对象也进行序列化，
 *  同样地，这些其它对象引用的另外对象也将被序列化，以此类推。所以，如果一个对象包含的成员变量是容器类对象，
 *  而这些容器所含有的元素也是容器类对象，那么这个序列化的过程就会较复杂，开销也较大。
 * 
 * 基于Serializable接口的序列化:
 * 1.当某个字段被声明为transient后，默认序列化机制就会忽略该字段。
 * 2.类的writeObject()方法与readObject()方法可以自定义序列化，可以序列化transient修饰的字段。
 *
 *
 * </pre>
 */
class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name = null;
	private transient Integer age = null;
	private Gender gender = null;

	public Person() {
		System.out.println("none-arg constructor");
	}

	public Person(String name, Integer age, Gender gender) {
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
		out.defaultWriteObject();// defaultWriteObject()方法，该方法会执行默认的序列化机制。
		out.writeInt(age);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		age = in.readInt();
	}
}