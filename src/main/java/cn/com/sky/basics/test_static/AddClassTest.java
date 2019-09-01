package cn.com.sky.basics.test_static;

import static cn.com.sky.basics.test_static.AddClass.add;
import static cn.com.sky.basics.test_static.AddClass.name;

public class AddClassTest {

    public static void main(String[] args) {
        System.out.println(add(1, 1));
        System.out.println(name);
        name = "zhangsan";
        System.out.println(name);
    }

}
