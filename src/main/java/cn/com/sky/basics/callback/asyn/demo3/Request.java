package cn.com.sky.basics.callback.asyn.demo3;

public class Request {

    public static void main(String[] args) {
        // 起一个线程，调用Response的handle方法
        new Thread(() ->
                new Response().handle("handle something",
                        data -> System.out.println("回调方法，收到数据 ：" + data))
        ).start();
        System.out.println("异步回调，先做其他事情");
    }

}