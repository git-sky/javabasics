package cn.com.sky.tools.serializable.kyro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

//Kryo序列化框架开发测试
//首先加入Kryo依赖包:
//asm-4.0.jar
//kryo-2.21-all.jar
//minlog-1.2.jar
//minlog-none-1.2.jar
//objenesis-1.2.jar
//reflectasm-1.07.jar

/**
 * kyro的bug太多，不建议使用，以下代码运行会报错，不知道为什么？
 */
public class TestKryo {

	private static final String FILE = "e:/file.bin";

	@Test
	public void test() {
		long start = System.currentTimeMillis();
		setSerializableObject();
		System.out.println("Kryo Serializable writeObject time:" + (System.currentTimeMillis() - start) + " ms");
		start = System.currentTimeMillis();
		getSerializableObject();
		System.out.println("Kryo Serializable readObject time:" + (System.currentTimeMillis() - start) + " ms");

	}

	private void setSerializableObject() {

		Kryo kryo = new Kryo();

		kryo.setReferences(false);

		kryo.setRegistrationRequired(false);

		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

		kryo.register(Simple.class);

		Output output;
		try {
			output = new Output(new FileOutputStream(FILE));
			for (int i = 0; i < 10; i++) {
				Map<String, Integer> map = new HashMap<String, Integer>(2);
				map.put("zhang0", i);
				map.put("zhang1", i);
				kryo.writeObject(output, new Simple("zhang" + i, (i + 1)));
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getSerializableObject() {
		Kryo kryo = new Kryo();

		kryo.setReferences(false);

		kryo.setRegistrationRequired(false);

		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

		Input input;
		try {
			input = new Input(new FileInputStream(FILE));
			Simple simple = null;
			while ((simple = kryo.readObject(input, Simple.class)) != null) {
				System.out.println(simple.getAge() + "  " + simple.getName());
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (KryoException e) {
			e.printStackTrace();
		}
	}

}

class Simple implements Serializable {

	private static final long serialVersionUID = -4914434736682797743L;

	private String name;
	private int age;

	public Simple() {
	}

	public Simple(String name, int age) {
		super();
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

}

// 现在我们来做个测试，与java自带的序列化做比较，看一下序列化与反序列化的运行时间与序列化后文件大小.
//
// //Java 序列化
// public class MyJavaSer {
//
// public static void main(String[] args) throws IOException, ClassNotFoundException {
// long start = System.currentTimeMillis();
// setSerializableObject();
// System.out.println("java Serializable writeObject time:" + (System.currentTimeMillis() - start) +
// " ms" );
// start = System.currentTimeMillis();
// getSerializableObject();
// System.out.println("java Serializable readObject time:" + (System.currentTimeMillis() - start) +
// " ms");
// }
//
// public static void setSerializableObject() throws IOException{
//
// FileOutputStream fo = new FileOutputStream("data.ser");
//
// ObjectOutputStream so = new ObjectOutputStream(fo);
//
// for (int i = 0; i < 1000000; i++) {
// Map<String,Integer> map = new HashMap<String, Integer>(2);
// map.put("zhang0", i);
// map.put("zhang1", i);
// so.writeObject(new Simple("zhang"+i,(i+1),map));
// }
// so.flush();
// so.close();
// }
//
// public static void getSerializableObject(){
// FileInputStream fi;
// try {
// fi = new FileInputStream("data.ser");
// ObjectInputStream si = new ObjectInputStream(fi);
//
// Simple simple =null;
// while((simple=(Simple)si.readObject()) != null){
// //System.out.println(simple.getAge() + "  " + simple.getName());
// }
// fi.close();
// si.close();
// } catch (FileNotFoundException e) {
// e.printStackTrace();
// } catch (IOException e) {
// //e.printStackTrace();
// } catch (ClassNotFoundException e) {
// e.printStackTrace();
// }
//
//
// }
//
// }

// 看一下测试结果(此测试是Simple类没带map属性的情况下测试的):
// Kryo:
// 运行时间:
// Kryo Serializable writeObject time:1203 ms
// Kryo Serializable readObject time:906 ms
// 文件大小:
// file.bin 13.2M
//
// Java:
// 运行时间
// java Serializable writeObject time:21156 ms
// java Serializable readObject time:15500 ms
// 文件大小:
// data.ser 22.7M
//
// 经过反复测试:
// Kryo的运行速度是java Serializable 的20倍左右
// Kryo的文件大小是java Serializable的一半左右。
//
// 注意：
// 经过测试，序列化对象最好不要带有Java集合类（如:Map,List等），如有会大大降低序列化效率。
