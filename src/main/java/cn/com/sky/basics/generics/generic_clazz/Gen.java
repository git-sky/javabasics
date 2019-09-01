package cn.com.sky.basics.generics.generic_clazz;

/**
 * 泛型类
 */
public class Gen<T> {

	private T t;

	public Gen(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

}