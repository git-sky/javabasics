package cn.com.sky.basics.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * <pre>
 * 
 * vm参数： -Xmx600m -Xms600m
 * 
 * 软引用
 * 
 * ReferenceQueue queue = new ReferenceQueue();
 * SoftReference ref=new SoftReference(aMyObject, queue); 
 * 
 * 当这个SoftReference所软引用的aMyOhject被垃圾收集器回收的同时，ref所强引用的SoftReference对象被列入ReferenceQueue。
 * 也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象的Reference对象。
 * 另外从ReferenceQueue这个名字也可以看出，它是一个队列，当我们调用它的poll()方法的时候，如果这个队列中不是空队列，那么将返回队列前面的那个Reference对象。
 * 在任何时候，我们都可以调用ReferenceQueue的poll()方法来检查是否有它所关心的非强可及对象被回收。如果队列为空，将返回一个null,否则该方法返回队列中前面的一个Reference对象。
 * 利用这个方法，我们可以检查哪个SoftReference所软引用的对象已经被回收。于是我们可以把这些失去所软引用的对象的SoftReference对象清除掉。常用的方式为:
 * 
 * </pre>
 */
public class TestSoftReferenceQueue {

	public static void main(String[] args) {
		System.out.println("开始");

		ArrayList<SoftReference> list = new ArrayList<>();

		ReferenceQueue queue = new ReferenceQueue();

		for (int i = 0; i < 5; i++) {
			A a = new A();
			SoftReference<A> sr = new SoftReference<A>(a, queue);// 软引用
			a = null;// 去掉强引用

			// A b = new A();// 创建一个强引用，当内存不够时，会回收上面的软引用。

			a = sr.get();
			System.out.println("a=" + a);
			list.add(sr);

		}

		for (SoftReference sr : list) {
			System.out.println("print:" + sr.get());
		}

		SoftReference ref = null;
		while ((ref = (SoftReference) queue.poll()) != null) {
			System.out.println("queue:" + ref);
		}

	}
}
