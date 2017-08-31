package cn.com.sky.basics.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

class Grocery {
	private static final int SIZE = 10000;
	private double[] d = new double[SIZE];
	private String id;

	public Grocery(String id) {
		this.id = id;
	}

	public String toString() {
		return id;
	}

	public void finalize() {
		System.out.println("Finalizing ... " + id);
	}

}

public class TestReferences {

	private static ReferenceQueue<Grocery> rq = new ReferenceQueue<Grocery>();

	public static void checkQueue() {
		Reference<? extends Grocery> ref = null;
		while ((ref = rq.poll()) != null) {
			System.out.println("queue:" + ref);
		}
	}

	public static void main(String[] args) {
		final int size = 5;
		Set<SoftReference<Grocery>> sa = new HashSet<SoftReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			SoftReference<Grocery> ref = new SoftReference<Grocery>(new Grocery("Soft " + i), rq);
			System.out.println("Just created: " + ref.get());
			sa.add(ref);
		}

		System.gc();
		checkQueue();

		Set<WeakReference<Grocery>> wa = new HashSet<WeakReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			WeakReference<Grocery> ref = new WeakReference<Grocery>(new Grocery("Weak " + i), rq);
			System.out.println("Just created: " + ref.get());
			wa.add(ref);
		}

		System.gc();
		checkQueue();

		Set<PhantomReference<Grocery>> pa = new HashSet<PhantomReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			PhantomReference<Grocery> ref = new PhantomReference<Grocery>(new Grocery("Phantom " + i), rq);
			System.out.println("Just created: " + ref.get());

			pa.add(ref);
		}

		System.gc();
		checkQueue();
	}
}