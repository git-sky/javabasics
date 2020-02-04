package cn.com.sky.basics.task;

import java.util.Timer;

/**
 * <pre>
 *
 * 定时器
 *
 * schedule(TimerTask task, Date time)设定指定任务task在指定时间time执行。
 * cancel()方法结束这个定时器。
 * schedule(TimerTask task, long delay, long period)方法设定指定任务task在指定延迟delay后进行固定延迟peroid的执行。
 * scheduleAtFixedRate(TimerTask task, long delay, long period)方法设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();

        // 在1秒后执行此任务,每次间隔2秒,
        timer.schedule(new MyTask(), 1000, 2000);

        // 这个是用来停止此任务的,否则就一直循环执行此任务了
        while (true) {
            try {
                int ch = System.in.read();
                if (ch - 'c' == 0) {
                    timer.cancel();// 使用这个方法退出任务
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTask extends java.util.TimerTask {
        @Override
        public void run() {
            System.out.println("run........");
        }
    }
}
