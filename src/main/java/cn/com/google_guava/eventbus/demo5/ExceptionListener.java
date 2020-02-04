package cn.com.google_guava.eventbus.demo5;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionListener.class);

    @Subscribe
    public void m1(final String event) {
        System.out.println("m1 " + event);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] and will take m1", event);
        }
    }

    @Subscribe
    public void m2(final String event) {
        System.out.println("m2 " + event);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] and will take m2", event);
        }
    }

    @Subscribe
    public void m3(final String event) {
        System.out.println("m3 " + event);

        throw new RuntimeException();
    }
}