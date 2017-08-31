package cn.com.sky.collections.map;

/**
 * <pre>
 * 
 * 如果重写equals()方法必须要重写hashCode()方法。
 * 任何时候只要a.equals(b),那么a.hashCode()必须和b.hashCode()相等。
 * 两者必须同时重写。
 * 
 * 重写equals方法时需要重写hashCode方法，主要是针对Map、Set等集合类型的使用 。
 * 
 * 因为关系到采用hash算法的集合；比如说当对象作为hashMap的key时。
 * 两个对象必须保证equals为true，hashcode相等；
 * 但hashcode相等，equals不必返回true
 * 你可以让hashcode返回常量，但是这样的话hash算法的效率就是线性查找了。
 * 
 * 【强制】Map/Set的key为自定义对象时，必须重写hashCode和equals。 正例：String重写了hashCode和equals方法，所以我们可以非常愉快地使用String对象作为key来使用。
 * 
 * </pre>
 */

public class TestEqualsDemo {

	public static void main(String args[]) {

		EqualDemo e1 = new EqualDemo("abc", 1);
		EqualDemo e2 = new EqualDemo("abc", 1);

		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));

		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());

	}

}

class EqualDemo {

	private String a;
	private int b;

	public EqualDemo(String a, int b) {
		this.a = a;
		this.b = b;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getA() {
		return a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getB() {
		return b;
	}

	public boolean equals(EqualDemo e) {
		return this.hashCode() == e.hashCode();
	}

	public int hashCode() {
		return 200;
	}
}
