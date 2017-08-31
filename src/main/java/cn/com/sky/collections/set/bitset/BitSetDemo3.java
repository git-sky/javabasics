package cn.com.sky.collections.set.bitset;

import java.util.BitSet;

/**
 * 位排序
 */
public class BitSetDemo3 {

	public static void main(String[] args) {
		int[] array = new int[] { 423, 700, 9999, 2323, 356, 6400, 1 };
		int len = array.length;

		BitSet bitSet = new BitSet(2 << 13); // 虽然可以自动扩容，但尽量在构造时指定估算大小
		System.out.println("BitSet size: " + bitSet.size());

		for (int i = 0; i < array.length; i++) {
			bitSet.set(array[i]);
		}
		 System.out.println("cardinality: " + bitSet.cardinality());

		int[] orderedArray = new int[len];
		int k = 0;
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			System.out.println(i);
			orderedArray[k++] = i;
		}

		System.out.println("After ordering: ");
		for (int i = 0; i < len; i++) {
			System.out.print(orderedArray[i] + "\t");
		}
	}

}