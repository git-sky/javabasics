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
 *
 * 2：实现Comparator 接口 的 int compare(T o1, T o2)方法；
 *
 *
 * </pre>
 */
public class TestCompare {

    @Test
    public void test() {
        List<Department> list = new ArrayList<>();
        list.add(new Department("2", "研发部", 11));
        list.add(new Department("1", "总公司", 13));
        list.add(new Department("2", "总公司", 12));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //实现Comparable接口，才可以用这个方法。
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Collections.sort(list, new Comparator<Department>() {
            @Override
            public int compare(Department department1, Department department2) {
                return department1.compareTo(department2);
            }

        });

        System.out.println("============Collections.sort ============");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Department dept1 = new Department("2", "研发部", 23);
        // Department dept2 = new Department("2", "kk", 44);
        // Set set = new TreeSet(new Comparator() {
        //
        // public int compare(Object arg0, Object arg1) {
        // return 0;
        // }
        //
        // });
        // set.add(dept1);
        // set.add(dept2);

    }

    class Department implements Comparable<Department> {
        private String id;
        private String name;
        private long num;

        public Department(String id, String name, long num) {
            this.id = id;
            this.name = name;
            this.num = num;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getNum() {
            return num;
        }

        public void setNum(long num) {
            this.num = num;
        }

        @Override
        public int compareTo(Department department) {
            int i = 0;
            i = this.id.compareTo(department.id);
            if (i != 0) {// 部门id不相等
                return i;
            } else {// 部门id相等
                i = this.name.compareTo(department.name);
                if (i != 0) {// 部门名称不相等
                    return i;
                } else {// 部门名称不相等
                    if (this.num > department.num) {
                        return 1;
                    } else if (this.num < department.num) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }

        }

        @Override
        public String toString() {
            return this.id + "-->" + this.name + "-->" + this.num;
        }
    }

}


