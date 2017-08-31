package cn.com.sky.basics.reference;

import java.lang.ref.WeakReference;

/**
 * <pre>
 * 
 * 弱引用
 * 
 * 当一个对象仅仅被weak reference指向, 而没有任何其他strong reference指向的时候, 如果GC运行, 那么这个对象就会被回收. 
 * weak reference的语法是:
 * WeakReference<Car> weakCar = new WeakReference(Car)(car); 
 * 当要获得weak reference引用的object时,
 * 首先需要判断它是否已经被回收: weakCar.get(); 如果此方法为空, 那么说明weakCar指向的对象已经被回收了.
 * 
 */
public class TestWeakReference {

	public static void main(String[] args) {

		Car car = new Car(22000, "silver");
		WeakReference<Car> weakCar = new WeakReference<Car>(car);

		int i = 0;

		while (true) {
			if (weakCar.get() != null) {
				i++;
				System.out.println("Object is alive for " + i + " loops - " + weakCar);
			} else {
				System.out.println("Object has been collected.");
				break;
			}
		}
	}

}