package cn.com.sky.tools;

import org.apache.commons.lang.time.StopWatch;

public class TestStopWatch {

    public static void main(String[] args) {

        StopWatch watch = new StopWatch();
        watch.start();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i <= 12000; i++) {
            sb.append(String.valueOf(i));
            sb.append(",");
        }
        watch.stop();
        System.out.println(watch.getTime());

    }

}
