package cn.com.sky.basics.callback.asyn.demo4;


public class Animal implements Eat {

    @Override
    public void eat(String str) {
        System.out.println("eat " + str);
    }
}