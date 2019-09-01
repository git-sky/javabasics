package cn.com.sky.rpc.simple_rpc_complex.test;

import java.util.Scanner;

import cn.com.sky.rpc.simple_rpc_complex.EncryXOR;
import cn.com.sky.rpc.simple_rpc_complex.RPC;
import cn.com.sky.rpc.simple_rpc_complex.local.ServerManager;
import cn.com.sky.rpc.simple_rpc_complex.protocal.Result;

public class ServerStop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户:");
        String name = sc.next();
        System.out.println("请输入密码:");
        String pawd = sc.next();

        ServerManager client = RPC.getProxy(ServerManager.class, RPC.DEFAULT_RPC_HOST, RPC.DEFAULT_RPC_PORT);

        name = EncryXOR.Encrytor(name);
        pawd = EncryXOR.Encrytor(pawd);
        Result result = client.stop(name, pawd);
        System.out.println("响应信息:" + result.getMsg());
    }
}