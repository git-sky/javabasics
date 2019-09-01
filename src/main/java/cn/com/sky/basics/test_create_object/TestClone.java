package cn.com.sky.basics.test_create_object;

/**
 * <pre>
 *
 * 通过克隆手段创建User对象
 *
 * 用clone方法创建对象并不会调用任何构造函数。
 *
 * 要使用clone方法，我们需要先实现Cloneable接口,并重写Object定义的clone方法。
 *
 * </pre>
 */
public class TestClone {

    public static void main(String[] args) throws Exception {

        User user = new User("zhangsan", 12);
        System.out.println(user);

        User user2 = (User) user.clone();// 不会调用User类的构造方法
        System.out.println(user2);
        System.out.println(user == user2);
        System.out.println(user.equals(user2));

    }

}
