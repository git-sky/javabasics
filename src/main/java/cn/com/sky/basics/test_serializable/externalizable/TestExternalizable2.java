package cn.com.sky.basics.test_serializable.externalizable;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestExternalizable2 {

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
  * Externalizable序列化机制
  * 
  * 实现Externalizable接口的类必须要提供一个无参的构造器，且它的访问权限为public。
  *
  * 使用Externalizable进行序列化，当读取对象时，会调用被序列化类的无参构造器去创建一个新的对象，然后再将被保存对象的字段的值分别填充到新对象中。
  * 
  * </pre>
  */
 class Person implements Externalizable {

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

 	@Override
 	public void writeExternal(ObjectOutput out) throws IOException {
 		out.writeObject(name);
 		out.writeInt(age);
 	}

 	@Override
 	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
 		name = (String) in.readObject();
 		age = in.readInt();
 	}
 }