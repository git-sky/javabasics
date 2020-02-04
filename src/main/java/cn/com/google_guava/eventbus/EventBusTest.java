package cn.com.google_guava.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;


public class EventBusTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventListener1());
        eventBus.post(1);
        eventBus.post(1L);
        eventBus.post("hello");
    }


    public static class EventListener1 implements EventListener {

        @Override
        public void listenInteger(Integer i) {//此方法不会被加入eventBus的loadingCache，父类方法取代之
            System.out.println("listenInteger=" + i);
        }

        @Override
        @Subscribe
        public void listenLong(Long l) {//此方法取代父类方法加入eventBus的loadingCache
            System.out.println("listenLong=" + l);
        }

        @Override
        @Subscribe
        @AllowConcurrentEvents
        public void listenString(String string) {//此方法取代父类方法加入eventBus的loadingCache
            System.out.println("listenString=" + string);
        }
    }

    public interface EventListener {
        @Subscribe
        @AllowConcurrentEvents
        void listenInteger(Integer i);

        @Subscribe
        @AllowConcurrentEvents
        void listenLong(Long i);

        @Subscribe
        @AllowConcurrentEvents
        void listenString(String string);
    }
}