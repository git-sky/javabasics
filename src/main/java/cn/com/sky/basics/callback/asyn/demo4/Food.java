package cn.com.sky.basics.callback.asyn.demo4;


public class Food {

    public void eatFood(Eat eat, String str) {
        System.out.println("produce " + str);
        eat.eat(str);
    }

}