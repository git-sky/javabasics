package cn.com.sky.collections.set.bitset;

import java.util.BitSet;

/**
 * 查找一个字符串中包含哪些字符
 */
public class WhichChars {

	private BitSet used = new BitSet();

	public WhichChars(String str) {
		System.out.println(used.size());
		for (int i = 0; i < str.length(); i++)
			used.set(str.charAt(i)); // set bit for char
	}

	public String toString() {
		String desc = "[";
		int size = used.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (used.get(i))
				desc += (char) i;
		}
		return desc + "]";
	}

	public static void main(String args[]) {
		WhichChars w = new WhichChars("How do you do");
		System.out.println(w);
	}
}
