package cn.com.sky.basics.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * <pre>
 *
 * vm参数： -Xmx600m -Xms600m
 *
 * 软引用
 *
 * sr.get();
 * 这时候sr是对obj的一个软引用，通过sr.get()方法可以取到这个对象，当然，当这个对象被标记为需要回收的对象时，则返回null；
 * 软引用主要用户实现类似缓存的功能，在内存足够的情况下直接通过软引用取值，无需从繁忙的真实来源查询数据，提升速度；当内存不足时，自动删除这部分缓存数据，从真正的来源查询这些数据。
 *
 * </pre>
 */
public class TestSoftReference {

    public static void main(String[] args) {
        System.out.println("开始");

        ArrayList<SoftReference> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            A a = new A();
            SoftReference<A> sr = new SoftReference<A>(a);// 软引用
            a = null;// 去掉强引用

            // A b = new A();// 创建一个强引用，当内存不够时，会回收上面的软引用。

            a = sr.get();
            System.out.println("a=" + a);
            list.add(sr);

        }

        for (SoftReference sr : list) {
            System.out.println("print:" + sr.get());
        }

    }
}

class A {
    int[] a;

    public A() {
        a = new int[100000000];
    }
}