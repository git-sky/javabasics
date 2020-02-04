package cn.com.sky.basics.callback.asyn.demo5;


public class Main {
    public static void main(String[] args) {
        Pay pay = new Account();
        WeChat weChat = new WeChat();
        weChat.pay(pay);
    }
}