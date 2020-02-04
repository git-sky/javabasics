package cn.com.google_guava.eventbus.demo;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractListener.class);

    @Subscribe
    public void commonTask(final String event) {
        System.out.println("AbstractListener " + event);

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Received event [{}] will be handle by {}.{}", new Object[]{event, this.getClass().getSimpleName(), "commonTask"});
        }
    }
}