package cn.com.sky.basics.compare;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *
 * Java对象比较大小有两种方法 :
 *
 * 1：实现Comparable 接口 的 public int compareTo(T o) 方法；
 *  Collections.sort(list);
 *  Collections.sort(list,Comparator);
 *
 * 2：实现Comparator 接口 的 int compare(T o1, T o2)方法；
 *  Collections.sort(list,Comparator);
 *
 *
 * </pre>
 */
public class TestComparable {


    /**
     * 对象Dog，实现了Comparable接口
     */
    @Test
    public void testComparable() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(2, 3));
        list.add(new Dog(4, 3));
        list.add(new Dog(1, 5));
        list.add(new Dog(2, 1));

        for (Dog dog : list) {
            System.out.println(dog);
        }

        System.out.println("============Collections.sort ============");

        //排序,默认使用Dog的排序方法。
        Collections.sort(list);

        for (Dog dog : list) {
            System.out.println(dog);
        }

    }

    /**
     * 对象Cat，没有实现Comparable接口
     */
    @Test
    public void testComparator() {
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(2, 3));
        list.add(new Cat(4, 3));
        list.add(new Cat(1, 5));

        for (Cat cat : list) {
            System.out.println(cat);
        }

        //1、自定义Comparator接口的实现类
        Comparator comparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                if (cat1.getA() - cat2.getA() == 0) {
                    return cat1.getB() - cat2.getB();
                } else {
                    return cat1.getA() - cat2.getA();
                }
            }
        };

        //排序,使用Comparator的排序方法。
        Collections.sort(list, comparator);

        System.out.println("============Collections.sort ============");

        for (Cat cat : list) {
            System.out.println(cat);
        }
    }
}
