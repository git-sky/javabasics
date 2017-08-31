package cn.com.sky.tools.serializable.jdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test {
	
	private final static class V implements Serializable {
		StringBuffer sb = new StringBuffer();
	};

	private static V v = new V();

	public static void main(String[] args) throws Exception {
		testWriteUnshared(3);
	}

	static void testWriteUnshared(int times) throws Exception {
		ByteArrayOutputStream bos1, bos2;
		ObjectOutputStream oos1, oos2;
		ByteArrayInputStream bin1, bin2;
		ObjectInputStream ois1, ois2;

		bos1 = new ByteArrayOutputStream();
		oos1 = new ObjectOutputStream(bos1);
		bos2 = new ByteArrayOutputStream();
		oos2 = new ObjectOutputStream(bos2);
		for (int i = 0; i < times; i++) {
			v.sb.append(i);
			/*
			 * 将同一个对象存储到同一流时，writeUnshared只是对v本身进行了多个复制，但 对象里所引用的其他成员对象如这里的sb是不会再次复制的，它会引用第一次向该
			 * 流写入时的同一个对象，所以当一个对象内部状态改变后通writeUnshared写入还 是不能更新，它只不过写入了另一个基层对象而已。
			 */
			oos1.writeUnshared(v);
			// 将同一对象写入同一流时，对象不会重新写入，而是引用第一次序列化后的对象
			oos2.writeObject(v);
		}

		bin1 = new ByteArrayInputStream(bos1.toByteArray());
		ois1 = new ObjectInputStream(bin1);
		bin2 = new ByteArrayInputStream(bos2.toByteArray());
		ois2 = new ObjectInputStream(bin2);
		V v = null;
		for (int i = 0; i < times; i++) {
			v = (V) ois1.readUnshared();
			/*
			 * 某次输出结果： Test$V@a62fc3 : 0 9023134 Test$V@1270b7 : 0 9023134 Test$V@60aeb0 : 0 9023134
			 */
			System.out.println(v + " :- " + v.sb + "  " + v.sb.hashCode());

			v = (V) ois2.readObject();
			/*
			 * 某次输出结果： Test$V@60aeb0 : 0 23899971 Test$V@60aeb0 : 0 23899971 Test$V@60aeb0 : 0
			 * 23899971
			 */
			System.out.println(v + " : " + v.sb + "  " + v.sb.hashCode());
		}
	}
}