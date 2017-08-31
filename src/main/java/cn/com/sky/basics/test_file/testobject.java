package cn.com.sky.basics.test_file;
import java.io.*;

public class testobject {
	public static void main(String args[]) throws Exception {
		T t = new T();
		t.k = 8;
		FileOutputStream fos = new FileOutputStream("d.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		oos.flush();
		oos.close();
		FileInputStream fis = new FileInputStream("d.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T tReaded = (T) ois.readObject();
		System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.d + " "
				+ tReaded.k);
	}
}

class T implements Serializable {

	private static final long serialVersionUID = 1L;
	int i = 10;
	int j = 9;
	double d = 2.3;
	transient int k = 15;
}