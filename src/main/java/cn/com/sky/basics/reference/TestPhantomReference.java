package cn.com.sky.basics.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * <pre>
 *
 *
 * 虚引用主要用来跟踪对象被垃圾回收器回收的活动。
 * 虚引用与软引用和弱引用的一个区别在于：
 * 虚引用必须和引用队列（ReferenceQueue）联合使用。当垃 圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。
 * 程序可以通过判断引用队列中是 否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。程序如果发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
 *
 *
 * </pre>
 */
public class TestPhantomReference {

    public static void main(String[] args) {

        ReferenceQueue queue = new ReferenceQueue();

        Car car = new Car(22000, "silver");
        PhantomReference<Car> pr = new PhantomReference<Car>(car, queue);

        car = null;

//		System.gc();
        System.out.println("aaaaaaaa");

        PhantomReference ref = null;
        while ((ref = (PhantomReference) queue.poll()) != null) {
            System.out.println("queue:" + ref);
        }
//		System.gc();
        System.out.println("bbbbbbbbbbb");

        PhantomReference refx = null;
        while ((refx = (PhantomReference) queue.poll()) != null) {
            System.out.println("queue:" + refx);
        }

    }

}
