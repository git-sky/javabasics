package cn.com.sky.rpc.simple_rpc_complex.test;

import cn.com.sky.rpc.simple_rpc_complex.Calculate;
import cn.com.sky.rpc.simple_rpc_complex.RPC;

public class MainClient1 {

	public static void main(String[] args) {
		Calculate client = RPC.getProxy(Calculate.class, RPC.DEFAULT_RPC_HOST, RPC.DEFAULT_RPC_PORT, 5000);
		int sum = client.add(2, 3);
		System.out.println(sum);
	}

}