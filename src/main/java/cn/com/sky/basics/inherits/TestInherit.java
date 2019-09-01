package cn.com.sky.basics.inherits;


/**
 * 创建对象的时候，不明确指定的话，默认调用无参构造方法。
 */
class Grandpa {

    protected Grandpa() {
        System.out.println("default Grandpa");
    }

    public Grandpa(String name) {
        System.out.println(name);
    }

}

class Father extends Grandpa {

    protected Father() {
//        super();默认会调用super()，写不写都一样
        System.out.println("default Father");
    }

    public Father(String grandpaName, String fatherName) {
        super(grandpaName);
        System.out.println(fatherName);
    }

}

class Child extends Father {

    public Child() {
//        super(); 默认会调用super()，写不写都一样
        System.out.println("default Child");
    }

    public Child(String grandpaName, String fatherName, String sonName) {
//        super(grandpaName, fatherName); 不写的话，默认调用父类无参构造方法。
        System.out.println(sonName);
    }

}

public class TestInherit {

    public static void main(String args[]) {
        Child s1 = new Child("My Grandpa", "My Father", "My Child"); // ①
//        Child s2 = new Child(); // ②
    }

}