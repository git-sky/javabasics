package cn.com.sky;

import java.lang.management.ManagementFactory;

/**
 * javaAPI取得java进程的PID
 */
public class ProgressUtil {

    public static String getCurrentPID() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        return pid;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(getCurrentPID());
        Thread.sleep(100000);
    }
}
