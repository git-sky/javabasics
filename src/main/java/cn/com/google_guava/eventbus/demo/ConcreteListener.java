package cn.com.google_guava.eventbus.demo;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteListener extends BaseListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractListener.class);

    @Subscribe
    public void conTask(final String event) {
        System.out.println("ConcreteListener " + event);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] will be handle by {}.{}", new Object[]{event, this.getClass().getSimpleName(), "conTask"});
        }
    }
}