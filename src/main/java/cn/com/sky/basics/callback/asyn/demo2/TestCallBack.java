package cn.com.sky.basics.callback.asyn.demo2;

/**
 * <pre>
 *
 * 回调是一种双向调用模式，什么意思呢，就是说，被调用方在被调用时也会调用对方，这就叫回调。“If you call me, i will call back”。
 *
 * 经典的使用回调的方式：
 * class A实现接口InA ——背景1
 * class A中包含一个class B的引用b ——背景2
 * class B有一个参数为InA的方法test(InA a) ——背景3
 * A的对象a调用B的方法传入自己，test(a) ——这一步相当于： you call me
 * 然后b就可以在test方法中调用InA的方法 ——这一步相当于：i call you back
 *
 *
 * 回调目前运用在什么场景比较多呢？从操作系统到开发者调用：
 *
 * 1、Windows平台的消息机制。
 *
 * 2、异步调用微信接口，根据微信返回状态对出业务逻辑响应。
 *
 * 3、Servlet中的Filter(过滤器)是基于回调函数，需容器支持。
 *
 *
 * 回调模式-测试类
 *
 * 客户端发送msg给服务端，服务端处理后（5秒），回调给客户端，告知处理成功。
 */
public class TestCallBack {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("Server,Hello！");
    }
}