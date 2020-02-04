package cn.com.google_guava.eventbus.demo2;

import com.google.common.eventbus.EventBus;


/**
 * 结论：eventBus会根据Listener的参数类型的不同，分别向不同的Subscribe发送不同的消息。
 */
public class MultipleEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleEventListeners());
        eventBus.post("I am String event");
        eventBus.post(1000);
    }
}