package cn.com.google_guava.eventbus.demo4;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;

/**
 * 当EventBus发布了一个事件，但是注册的订阅者中没有找到处理该事件的方法，那么EventBus就会把该事件包装成一个DeadEvent事件来重新发布.
 */
public class DeadEventBusExample {

    public static void main(String[] args) {
        //重写EventBus的toString方法，使eventBus的名称为DEAD-EVENT-BUS
        final EventBus eventBus = new EventBus() {
            @Override
            public String toString() {
                return "DEAD-EVENT-BUS";
            }
        };
        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);
        eventBus.post("DeadEventListener event");
        eventBus.post(new DeadEvent("abc", "123"));
    }
}