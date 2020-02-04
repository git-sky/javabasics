package cn.com.sky.basics.callback.asyn.demo5;


public class WeChat {

    public void pay(Pay pay) {
        System.out.println("WeChat pay start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WeChat pay finished...");
        pay.payFinish();
    }
}