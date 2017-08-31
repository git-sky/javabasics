package cn.com.sky.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * RandomAccess 标识支持快速随机访问
 */
public class TestRandomAccess {

	public static void main(String[] args) {
		List arrayList = new ArrayList();
		List linkedList = new LinkedList();

	}

	private void get(List list, int index) {
		if (list instanceof RandomAccess) {
			list.get(index);
		} else {

		}
	}

}
