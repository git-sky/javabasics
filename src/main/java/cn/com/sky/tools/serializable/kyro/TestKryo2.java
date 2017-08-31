package cn.com.sky.tools.serializable.kyro;

import org.junit.Test;

import cn.com.sky.tools.serializable.Student;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class TestKryo2 {

	@Test
	public void test() {
		Kryo kryo = new Kryo();
		// kryo.setReferences(true);
		// kryo.setRegistrationRequired(true);
		// kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		// 注册类
		Registration registration = kryo.register(Student.class);
		long time = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			// 序列化
			Output output = null;
			// ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			// output = new Output( outStream , 4096);
			output = new Output(1, 4096);
			Student student = new Student("zhangsan", 'm', 23);
			kryo.writeObject(output, student);
			byte[] bb = output.toBytes();
			// System.out.println(bb.length);
			output.flush();

			// 反序列化
			Input input = null;
			// input = new Input(new
			// ByteArrayInputStream(outStream.toByteArray()),4096);
			input = new Input(bb);
			Student s = (Student) kryo.readObject(input, registration.getType());
			System.out.println(s.getName() + "," + s.getSex());
			input.close();
		}
		time = System.currentTimeMillis() - time;
		System.out.println("time:" + time);
	}
}
