package cn.com.sky.tools.serializable.jdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * Serializable接口的自动序列化行为的控制。
 * 
 * 我们可以实现 Serializable 接口，并添加 ( 注：我说的是 " 添加 " ，而不是 " 实现 " 或 " 重载 ") 名为 writeObject() 和 readObject() 的方法。
 * 这样一旦对象被序列化或都被反序列化，就会自动地分别调用这两个方法。也就是说，只要我们提供了这两个方法，就会使用它们而不是缺省的序列化机制 。
 * 
 * 这些方法必须具有准确的方法签名：
 * private void writeObject(ObjectOutputStream stream) throws IOException;
 * private void readObject(ObjectInputStream stream) throws IOException,CalssNot  FoundException
 * 
 * 从设计的观点来看，现在事情变得真是不可思议。它们被定义成了 private ，这意思味着它们不能被这个类的其成员调用。
 * 然面，实际上我们并没有从这个类的其他方法中调用它们，而是 ObjectOutputStream 和 ObjectInputStream 对象的 writeObject() 和 readObject() 方法
 * 调用我们对象的 writeObject() 和 readObject() 方法 。
 * 
 * 在你调用 ObjectOutputStream.writeObject() 时，会检查你所传递的 Serializable 对象，看是否实现 ( 准确的说应该是添加 ) 了它自己的 writeObject() ，
 * 如果是这样，就跳过正常的序列化过程并调用它的 writeObject() 。 readObject() 的情形与此相同。
 *  
 * 
 * 还有另外一个技巧。在我们添加的 writeObject(ObjectOutputStream stream) 内部，可以调用 defaultWriteObject() 来选择执行缺省的 writeObject() 。
 * 类似地，在 readObject(ObjectInputStream stream) 内部，我们可以调用 defaultReadObject() 。 
 * 
 * 注：如果某实现了 Serializable 接口并添加了 writeObject() 与 readObject() 方法的类，
 * 要保存非 transient 部分，那么我们必须调用 defaultWriteObject() 操作作为 writeObject() 中的第一个操作，
 * 并让 defaultReadObject() 作为 readObject() 中的第一个操作，如果不这样的话，我们只能手动一个个存储与恢复了 。
 * 
 */
public class SerialCtl implements Serializable {

	private static final long serialVersionUID = 1L;

	// 非transient域可由defaultWriteObject()方法保存
	private String a;
	// transient域必须在程序中明确保存和恢复
	private transient String b;

	// 默认构造函数，反序列化时不会调用
	public SerialCtl() {
		System.out.println("defuault constructor");
	}

	// 构造函数，反序列化时不会调用
	public SerialCtl(String aa, String bb) {
		System.out.println("SerialCtl(String aa, String bb)");
		a = "Not Transient: " + aa;
		b = "Transient: " + bb;
	}

	public String toString() {
		return a + "\n" + b;
	}

	/*
	 * 添加writeObject(ObjectOutputStream stream)私有方式， 序列化时会自动由ObjectOutputStream对象的writeObject方法来调用
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		// 要在首行调用默认序列化方法
		stream.defaultWriteObject();
		// 我们手工序列化那些调用默认序列化方法（defaultWriteObject）无法序列化的属性
		stream.writeObject(b);
	}

	/*
	 * 添加readObject(ObjectInputStream stream)私有方式， 序列化时会自动由ObjectInputStream对象的readObject方法来调用
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		// 要在首行调用默认序列化方法
		stream.defaultReadObject();
		// 我们手工反序列化那些调用默认反序列化方法（defaultReadObject）无法反序列化的属性
		b = (String) stream.readObject();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Before:\n" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		// Now get it back:
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After:\n" + sc2);

	}
}
