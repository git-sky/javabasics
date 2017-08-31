
package cn.com.sky.basics.initial.demo1;

/*
 * 类的初始化顺序
 */
public class TestC {

	F1 f1=new F1("TestC1");
	F2 f2=new F2("TestC2");
	
	public static void main(String[] args){
		new C();
	}
	
}