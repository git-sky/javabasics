package cn.com.sky.basics.callback.asyn.demo4;


public class Main {

    public static void main(String[] args) {
        Food food = new Food();

        Person p = new Person();
        food.eatFood(p, "milk");

        Animal animal = new Animal();
        food.eatFood(animal, "grass");

    }
}