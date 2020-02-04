package cn.com.sky.basics.callback.asyn.demo5;


public class Account implements Pay {

    @Override
    public void payFinish() {
        System.out.println("Account payFinish...");
    }

    @Override
    public void payFail() {
        System.out.println("Account payFail...");
    }
}