package cn.com.sky.basics.callback.asyn.demo3;

import java.util.concurrent.TimeUnit;

public class Response {

    public void handle(String msg, CallBack callBack) {
        System.out.println("接收到的msg = " + msg);
        try {
            // sleep 3 秒，模拟满足某些条件
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 调用回调方法
        callBack.onResponse("请求完成，响应success");
    }

}