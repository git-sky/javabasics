package cn.com.sky.rpc.simple_rpc2.test;

import cn.com.sky.rpc.simple_rpc2.Calculate;
import cn.com.sky.rpc.simple_rpc2.RemoteCalculate;
import cn.com.sky.rpc.simple_rpc2.local.ServerManager;
import cn.com.sky.rpc.simple_rpc2.local.impl.ServerManagerImpl;

public class MainServer {

	public static void main(String[] args) {

		ServerManager server = new ServerManagerImpl();
		server.register(Calculate.class, RemoteCalculate.class);
		server.start();

		Runtime.getRuntime().addShutdownHook(new Thread() {// 添加jvm退出钩子
					public void run() {
						System.out.println("服务器已停止...");
					}
				});

	}
}