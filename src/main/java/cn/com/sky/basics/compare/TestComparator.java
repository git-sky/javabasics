package cn.com.sky.basics.compare;

import org.junit.Test;
import org.junit.runner.Computer;

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
 */
public class TestComparator {


    @Test
    public void test() {
        ArrayList<Computer> list = new ArrayList<>();
        Computer t1 = new Computer(1, 2);
        Computer t2 = new Computer(2, 3);
        Computer t3 = new Computer(4, 5);
        list.add(t2);
        list.add(t1);
        list.add(t3);

        for (Iterator<Computer> iterator = list.iterator(); iterator.hasNext(); ) {
            Computer computer = iterator.next();
            System.out.println(computer.a + ":" + computer.b);
        }

        System.out.println("==============Collections.sort==============");

        //比较器
        Comparator<Computer> comparator = new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.a - o2.a;
            }
        };
        Collections.sort(list, comparator);

        for (Iterator<Computer> iterator = list.iterator(); iterator.hasNext(); ) {
            Computer computer = iterator.next();
            System.out.println(computer.a + ":" + computer.b);
        }
    }

    class Computer {
        private int a;
        private int b;

        public Computer(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
