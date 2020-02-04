package cn.com.sky.rpc.simple_rpc_complex.test;

import cn.com.sky.rpc.simple_rpc_complex.Calculate;
import cn.com.sky.rpc.simple_rpc_complex.RPC;

/**
 * 客户端2
 */
public class MainClient2 {

    public static void main(String[] args) {
        Calculate client = RPC.getProxy(Calculate.class, RPC.DEFAULT_RPC_HOST, RPC.DEFAULT_RPC_PORT, 5000);
        int sum = client.multi(3, 5);
        System.out.println(sum);
    }
}