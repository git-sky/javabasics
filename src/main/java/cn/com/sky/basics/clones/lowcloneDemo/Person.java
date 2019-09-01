package cn.com.sky.basics.clones.lowcloneDemo;

public class Person implements Cloneable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Person clone() {
        Person p = null;
        try {
            p = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void display() {
        System.out.println("name:" + name + "	age:" + age);
    }
}