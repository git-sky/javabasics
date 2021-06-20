package cn.com.todo.test_basic;
import java.util.*;

/*
 * �Ƚ�list��Ч��
 */
public class ListDemo {
	static final int N = 50000;

	static long timeList(List list) {
		long start = System.currentTimeMillis();
		Object o = new Object();
		for (int i = 0; i < N; i++)
			list.add(0, o);
		return System.currentTimeMillis() - start;
	}

	public static void main(String[] args) {
		System.out.println("ArrayList��ʱ��" + timeList(new ArrayList()));
		System.out.println("LinkedList��ʱ��" + timeList(new LinkedList()));
	}
}
