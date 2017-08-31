package cn.com.sky.basics.generics;

/**
 * 泛型类
 */
public class Gen2<T, K extends Comparable<?>> {

	private T t;
	private K k;

	public Gen2(T t) {
		this.t = t;
	}

	public Gen2(T t, K k) {
		this.t = t;
		this.k = k;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}
}