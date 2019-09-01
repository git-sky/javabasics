package cn.com.sky.basics.test_unsafe;

import java.io.Serializable;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class TestInstance implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Unsafe unsafe;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);

		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	// Instantiating it using constructor, reflection and unsafe gives different results.
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		A o1 = new A(); // constructor
		o1.a(); // prints 1
		System.out.println(o1.a());

		A o2 = A.class.newInstance(); // reflection
		o2.a(); // prints 1
		System.out.println(o2.a());

		A o3 = (A) unsafe.allocateInstance(A.class); // unsafe
		o3.a(); // prints 0
		System.out.println(o3.a());

	}

}

class A {
	private long a; // not initialized value

	public A() {
		this.a = 1; // initialization
	}

	public long a() {
		return this.a;
	}
}
