package cn.com.sky.basics.test_create_object;

import java.io.Serializable;

/**
 * <pre>
 * 对象创建的几种方法:
 * 1. 使用new关键字
 * 2. 使用clone方法
 * 3. 反射机制
 * 4. 反序列化
 * 5. sun.misc.Unsafe类
 *
 * 以上 五种都可以产生java对象
 * 1,3都会明确的显式的调用构造函数
 * 2是在内存上对已有对象的影印,所以不会调用构造函数
 * 4是从文件中还原类的对象,也不会调用构造函数
 *
 *
 * Java几种常见的创建对象的方法：
 *
 * 1、使用new关键字创建对象
 *
 * 2、利用java的反射机制，通过java.lang.Class或者java.lang.reflect.Constructor创建对象
 *
 * 3、实现Cloneable接口，然后重写Object.clone()方法创建对象
 *
 * 4、实现序列化serialiable接口，通过反序列化，ObjectInputStream的readObject()方法创建对象
 *
 * 5、String str="abc" 直接由jvm创建 或者使用 字符串操作符"+"  String str1 = "a"+"bc"由jvm创建
 *
 * 6、使用sun.misc.Unsafe类
 */
public class User implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;

    public User() {
        super();
        System.out.println("User(),无参构造方法");
    }

    private User(String name) {
        this(name, 0);
    }

    public User(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
        System.out.println("User(String name, Integer age),有参构造方法");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        final User other = (User) o;
        if (this.name.equals(other.name) && this.age == other.age)
            return true;
        else
            return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void say() {
        System.out.println("say..........");
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
