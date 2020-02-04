package cn.com.sky.basics.test_runtime;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestRuntimeExec {
    private static void setIP(String newip) throws Exception {

        Runtime.getRuntime().exec("netsh   interface   ip   set   addr  \"本地连接\"   static   " + newip + "   255.255.255.0   192.168.1.18   1 ");
    }

    public static void main(String[] args) throws Exception {

        try {
            System.out.println("本机的IP = " + InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("Begin>>>>>>>>>>>>>>>>>>>>");
        // setIP("192.168.1.100");
        System.out.println("Set   ip   successful! ");
    }
}