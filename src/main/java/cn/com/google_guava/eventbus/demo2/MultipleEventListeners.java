package cn.com.google_guava.eventbus.demo2;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleEventListeners {
    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleEventListeners.class);

    @Subscribe
    public void task1(final String event) {
        System.out.println("task1 " + event);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] and will take a action by ==task1==", event);
        }
    }

    @Subscribe
    public void task2(final String event) {
        System.out.println("task2 " + event);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] and will take a action by ==task2==", event);
        }
    }

    @Subscribe
    public void intTask(final Integer event) {
        System.out.println("intTask " + event);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] and will take a action by ==intTask==", event);
        }
    }
}