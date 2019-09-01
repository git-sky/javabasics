package cn.com.sky.basics.reflect.constructor;

public class User {

    public User() {
        System.out.println("User()");
    }

    public User(String str) {
        System.out.println("User(String str)");
    }

    public User(String str, Integer i) {
        System.out.println("User(String str, Integer i)");
    }

    public User(String str, int i) {
        System.out.println("User(String str, int i)");
    }


    private User(String str1, String str2) {
        System.out.println("User(String str1, String str2)");
    }


}
