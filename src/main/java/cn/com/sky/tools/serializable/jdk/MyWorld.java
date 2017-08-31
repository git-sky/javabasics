package cn.com.sky.tools.serializable.jdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 只要我们将任何对象序列化到一个单一流中，我们就可以恢复出与我们写出时一样的对象 网，并且没有任何意外重复复制出的对象。
 * 当然，我们可以在写出第一个对象与写出第二个对象期间改变这些对象的状态，这种更新操作对存储到同一流中的序列化操作不起作用； 只对更新状态后再存储到另一流中起作用。
 * </pre>
 */
public class MyWorld {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		House house = new House();
		List animals = new ArrayList();
		// 让三种动物都引用同一个对象house
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		animals.add(new Animal("Fronk the cat", house));

		System.out.println("animals:" + animals);

		System.out.println("----开始序列化");
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);

		// 试着改变状态
		((Animal) animals.get(0)).setName("pig pig...");

		/*
		 * 再往同一输出流序列化一次，实质上上面的改变状态操作对这次序列化不会起作用，这里存储的 对象状态还是为第一次序列化时的属性那个状态，但在改变状态后，如果序列化到另一个输出流
		 * 中时，这时会以最新对象状态来序列化
		 */
		o1.writeObject(animals);// 再存一次
		System.out.println(((Animal) animals.get(0)).getName());

		// 序列化到另外一个流中
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);

		System.out.println("----开始反序列化");
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		/*
		 * 注，上面o1存储了两遍，现也同样从in1读取两遍，同一流中如果对同一对象存储多次后， 在读取时，也是同一对象
		 */
		List animals1 = (List) in1.readObject();
		List animals2 = (List) in1.readObject();

		// 如果输入到不同的流中时，尽管是存储的同一对象，但恢复过来时是不同的对象(内存地址不一样)
		List animals3 = (List) in2.readObject();

		System.out.println("animals1:" + animals1);
		System.out.println("animals2:" + animals2);
		System.out.println("animals3:" + animals3);
	}
}

class House implements Serializable {
	private static final long serialVersionUID = 7763424872069972808L;
}

class Animal implements Serializable {
	private static final long serialVersionUID = 4585314037312913787L;
	private String name;
	private House preferredHouse;

	public Animal(String nm, House h) {
		name = nm;
		preferredHouse = h;
	}

	public String toString() {
		return name + "[" + super.toString() + "]," + preferredHouse + "\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
