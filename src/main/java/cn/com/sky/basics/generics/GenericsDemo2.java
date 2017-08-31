package cn.com.sky.basics.generics;

class Notepad<K, V> { // 此处指定了两个泛型类型
	private K key; // 此变量的类型由外部决定
	private V value; // 此变量的类型由外部决定

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

public class GenericsDemo2 {
	public static void main(String args[]) {
		Notepad<String, Integer> pad = null; // 定义两个泛型类型的对象
		pad = new Notepad<String, Integer>(); // key为String，value为Integer
		pad.setKey("汤姆"); // 设置第一个内容
		pad.setValue(20); // 设置第二个内容
		System.out.print("姓名；" + pad.getKey()); // 取得信息
		System.out.print("，年龄；" + pad.getValue()); // 取得信息

	}
}
