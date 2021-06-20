package cn.com.todo.test_basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// //1�� remove()ȥ�����ǵ�ǰit.next()���ص�Ԫ��
		// List<String> list = new ArrayList<String>();
		// for (int i = 0; i < 10; i++) {
		// String str = i + "";
		// list.add(str);
		// }
		// Iterator it = list.iterator();
		// for (int i = 0; i < 5; i++) {
		// System.out.println((String) it.next());
		// }
		// it.remove();
		// System.out.println("////////////////////////");
		// it = list.iterator();
		// while (it.hasNext()) {
		// System.out.println((String) it.next());
		// }

		// 2�� remove()�󣬶������Ԫ�ر���ûӰ��
		List<String> list2 = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String str = i + "";
			list2.add(str);
		}
		Iterator it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println((String) it2.next());
			it2.remove();
		}
	}

}
