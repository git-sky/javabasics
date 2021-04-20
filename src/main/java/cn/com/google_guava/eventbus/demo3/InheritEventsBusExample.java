package cn.com.google_guava.eventbus.demo3;

import com.google.common.eventbus.EventBus;

/**
 * 结论：当作为参数的event之间有继承关系时，使用eventBus发送消息，event的父类，listener也会对此消息进行处理。
 */
public class InheritEventsBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new FruitEaterListener());
        eventBus.post(new Apple("apple"));
//        eventBus.post(new Fruit("fruit"));
    }
}