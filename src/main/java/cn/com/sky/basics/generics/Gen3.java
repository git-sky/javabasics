package cn.com.sky.basics.generics;

/**
 * 泛型类
 */
public class Gen3<T, K extends Comparable<? super Double>> {

	private T t;
	private K k;

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public Gen3(T t) {
		this.t = t;
	}

	public Gen3(T t, K k) {
		this.t = t;
		this.k = k;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}