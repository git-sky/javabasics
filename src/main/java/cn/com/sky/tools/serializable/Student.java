package cn.com.sky.tools.serializable;

import java.io.Serializable;


/**
 * 不实现Serializable接口，序列化的时候会报错：
 * java.io.NotSerializableException: cn.com.sky.tools.serializable.Student
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -2813737418568644561L;

    private String name;
    private char sex;
    private int age;
    private double height;
    private transient double weight;
    private static String nation;

    public Student() {
    }

    public Student(String name, char sex, int age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(String name, char sex, int age, double height) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
    }

    public Student(String name, char sex, int age, double height, double weight) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Student(String name, char sex, int age, double height, double weight, String nation) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Student.nation = nation;
    }

}