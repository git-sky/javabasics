package cn.com.sky.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestExceptions {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestExceptions.class);

    private static Logger logger = LoggerFactory.getLogger("info_log");


    public static void main(String[] args) {
        process();
        System.out.println("++++++++++++++++");
    }


    private static void process() {
        try {
            LOGGER.info("process");
            new Long("abc");
        } catch (NumberFormatException e) {
            /**
             * 这样打印异常
             */
            LOGGER.error("aaaaaa", e);

//            e.printStackTrace();

            /**
             * 会吞掉异常栈的信息，不要这样使用
             */
//            LOGGER.error("aaaaaa" + e);
            System.out.println("==================");
//            throw e;
            throw new MyBusinessException("A message that describes the error.", e);

        }
    }
}
