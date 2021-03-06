package cn.com.sky.collections.set.bitset;

import java.util.BitSet;

public class MainTestFive {

	public static void main(String[] args) {
		int[] shu = { 2, 42, 5, 6, 6, 18, 33, 15, 25, 31, 28, 37 };
		BitSet bm1 = new BitSet(MainTestFive.getMaxValue(shu));
		System.out.println("bm1.size()--" + bm1.size());

		MainTestFive.putValueIntoBitSet(shu, bm1);
		printBitSet(bm1);
	}

	// 打印
	public static void printBitSet(BitSet bs) {
		StringBuffer buf = new StringBuffer();
		buf.append("[\n");
		for (int i = 0; i < bs.size(); i++) {
			if (i < bs.size() - 1) {
				buf.append(MainTestFive.getBitTo10(bs.get(i)) + ",");
			} else {
				buf.append(MainTestFive.getBitTo10(bs.get(i)));
			}
			if ((i + 1) % 8 == 0 && i != 0) {
				buf.append("\n");
			}
		}
		buf.append("]");
		System.out.println(buf.toString());
	}

	// 找出数据集合最大值
	public static int getMaxValue(int[] zu) {
		int temp = 0;
		temp = zu[0];
		for (int i = 0; i < zu.length; i++) {
			if (temp < zu[i]) {
				temp = zu[i];
			}
		}
		System.out.println("maxvalue:" + temp);
		return temp;
	}

	// 放值
	public static void putValueIntoBitSet(int[] shu, BitSet bs) {
		for (int i = 0; i < shu.length; i++) {
			bs.set(shu[i], true);
		}
	}

	// true,false换成1,0为了好看
	public static String getBitTo10(boolean flag) {
		if (flag == true) {
			return "1";
		} else {
			return "0";
		}
	}

}