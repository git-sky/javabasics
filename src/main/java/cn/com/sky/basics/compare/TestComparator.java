package cn.com.sky.basics.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * <pre>
 * 
 * 在JDK7版本以上，Comparator要满足自反性，传递性，对称性，不然Arrays.sort，Collections.sort会报IllegalArgumentException异常。
 *  说明： 
 *  1） 自反性：x，y的比较结果和y，x的比较结果相反。 
 *  2） 传递性：x>y,y>z,则x>z。 
 *  3） 对称性：x=y,则x,z比较结果和y，z比较结果相同。
 *  
 * </pre>
 * 
 */
public class TestComparator {

	public static void main(String[] args) {

		Comparator<TstComp> c = new Comparator<TstComp>() {
			@Override
			public int compare(TstComp o1, TstComp o2) {
				return o1.a - o2.a;
			}
		};

		TstComp t1 = new TstComp(1, 2);
		TstComp t2 = new TstComp(2, 3);
		TstComp t3 = new TstComp(4, 5);
		ArrayList<TstComp> list = new ArrayList<TstComp>();
		list.add(t2);
		list.add(t1);
		list.add(t3);

		for (Iterator<TstComp> iterator = list.iterator(); iterator.hasNext();) {
			TstComp t = iterator.next();
			System.out.println(t.a + ":" + t.b);
		}

		Collections.sort(list, c);

		for (Iterator<TstComp> iterator = list.iterator(); iterator.hasNext();) {
			TstComp t = iterator.next();
			System.out.println(t.a + ":" + t.b);
		}
	}

	static class TstComp {
		private int a;
		private int b;

		public TstComp(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
