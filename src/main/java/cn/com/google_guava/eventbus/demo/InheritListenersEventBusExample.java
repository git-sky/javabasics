package cn.com.google_guava.eventbus.demo;

import com.google.common.eventbus.EventBus;

/**
 * 结论：注册了一个Listener，使用eventBus发送消息，它的父类的Subscribe也会对此消息进行处理。
 */
public class InheritListenersEventBusExample {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new ConcreteListener());
        eventBus.post("I am String event");
        eventBus.post(1000);
    }
}