package cn.com.sky.lamda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFilter {

    @Test
    public void test() {
        MyStudent stuA = new MyStudent(1, "A", "M", 184);
        MyStudent stuB = new MyStudent(2, "B", "G", 163);
        MyStudent stuC = new MyStudent(3, "C", "M", 175);
        MyStudent stuD = new MyStudent(4, "D", "G", 158);
        MyStudent stuE = new MyStudent(5, "E", "M", 170);

        List<MyStudent> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);


        //传统过滤方式
        Iterator<MyStudent> iterator = list.iterator();
        while (iterator.hasNext()) {
            MyStudent stu = iterator.next();
            if (stu.getSex().equals("G")) {
                System.out.println(stu.toString());
            }
        }

        System.out.println(list);

        System.out.println("--------------------------------------------");

        //filter方式
        list.stream()
                .filter(student -> student.getSex().equals("G"))
                .forEach(student -> System.out.println(student.toString()));

        System.out.println(list);

    }

    public static class MyStudent {

        private int no;
        private String name;
        private String sex;
        private float height;

        public MyStudent(int no, String name, String sex, float height) {
            this.no = no;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "MyStudent{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", height=" + height +
                    '}';
        }
    }

}