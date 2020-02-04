package cn.com.google_guava.eventbus.demo3;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FruitEaterListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(FruitEaterListener.class);

    @Subscribe
    public void eat(Fruit event) {
        System.out.println("eat Fruit " + event);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Fruit eat[{}]. ", event);
        }
    }

    @Subscribe
    public void eat(Apple event) {
        System.out.println("eat Apple " + event);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Apple eat[{}]. ", event);
        }
    }
}