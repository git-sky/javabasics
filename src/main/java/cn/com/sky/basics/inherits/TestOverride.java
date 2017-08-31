package cn.com.sky.basics.inherits;
//package cn.com.sky.basics;
//
///**
// * 
// * 方法的重写
// * 
// */
//
//public class TestOverride {
//
//	public static void main(String args[]) {
//
//		B b = new B();
//		b.show();
//
//	}
//}
//
//class A {
//	public void show() {
//		a();
//		b();
//		c();
//		d();
//		e();
//	}
//
//	public void a() {
//		System.out.println("a in A");
//	}
//
//	protected void b() {
//		System.out.println("b in A");
//	}
//
//	void c() {
//		System.out.println("c in A");
//	}
//
//	private void d() {
//		System.out.println("d in A");
//	}
//
//	protected void e() {
//		System.out.println("e in A");
//	}
//
//}
//
//class B extends A {
//
//	public void a() {
//		System.out.println("a in B");
//	}
//
//	public void b() {
//		System.out.println("b in B");
//	}
//
//	public void c() {
//		System.out.println("c in B");
//	}
//
//	public void d() {
//		System.out.println("d in B");
//	}
//
//	protected void e() {
//		System.out.println("e in B");
//	}
//
//}
