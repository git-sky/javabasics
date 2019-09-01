package cn.com.sky.basics.clones.lowcloneDemo;


public class TestClone {
    public static void main(String args[]) {

        Person p1 = new Person("Tom", 12);
        Person p2 = p1.clone();

        System.out.println(p1 == p2);
        p1.display();
        p2.display();

        p1.setName("Cat");
        p1.setAge(30);
        System.out.println("==========================");

        p1.display();
        p2.display();

    }

}
