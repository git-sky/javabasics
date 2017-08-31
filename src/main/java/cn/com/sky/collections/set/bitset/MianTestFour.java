package cn.com.sky.collections.set.bitset;

import java.util.BitSet;

/**
 * 说明你申请的位都是以64为倍数的，就是说你申请不超过一个64的就按64算，超过一个不超过 2个的就按128算。
 */
public class MianTestFour {

	public static void main(String[] args) {
		BitSet bm1 = new BitSet(7);
		System.out.println(bm1.isEmpty() + "--" + bm1.size());

		BitSet bm2 = new BitSet(63);
		System.out.println(bm2.isEmpty() + "--" + bm2.size());

		BitSet bm3 = new BitSet(65);
		System.out.println(bm3.isEmpty() + "--" + bm3.size());

		BitSet bm4 = new BitSet(111);
		System.out.println(bm4.isEmpty() + "--" + bm4.size());
	}

}