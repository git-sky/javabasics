package cn.com.sky.basics.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * <pre>
 *
 * 弱引用
 */
public class TestWeakReferenceQueue {

    public static void main(String[] args) {

        ReferenceQueue queue = new ReferenceQueue();

        for (int j = 0; j < 10; j++) {
            Car car = new Car(22000, "silver");
            WeakReference<Car> weakCar = new WeakReference<Car>(car, queue);

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

        WeakReference ref = null;
        while ((ref = (WeakReference) queue.poll()) != null) {
            System.out.println("queue:" + ref);
        }

    }
}