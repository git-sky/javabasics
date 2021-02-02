package cn.com.log_tools.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Demo {

    private static Logger log = LoggerFactory.getLogger(Log4j2Demo.class);
    private static Logger logName = LoggerFactory.getLogger("warn_log");

    public static void main(String[] args) {

        System.out.println("aaaaaaaaaaa");

        Log4j2Demo.Student s = null;// new Student();

        // log.trace("======trace,{}", s.getAge());
//        log.debug("======debug,{}", s.getAge());// 就是高于debug级别,也会抛异常
        if (log.isDebugEnabled()) {// 正常
            log.debug("======debug,{}", s.getAge());
        }
        log.info("======info");
        log.warn("======warn");
        log.error("======error");

        // logName.trace("======trace===logName===");
        // logName.debug("======debug===logName===");
        // logName.info("======info===logName===");
        // logName.warn("======warn===logName===");
        // logName.error("======error===logName===");

    }

    private class Student {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}