package cn.com.todo.test_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new Point(1, 1));
		al.add(new Point(2, 2));
		al.add(new Point(3, 3));
		al.add(4);
		al.add(5);
		Object[] obj = al.toArray();
		for(int i=0;i<obj.length;i++){
			System.out.println(obj[i]);
		}
		List l = Arrays.asList(obj);
		System.out.println(l);
		
		Iterator it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}