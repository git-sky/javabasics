package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.com.sky.rpc.rmi.rmi1.RMIServer;
import cn.com.sky.rpc.rmi.rmi1.RMIServerImpl;

public class MainClient2 {

	public static void main(String[] args) throws RemoteException, NotBoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
		RMIServer client = new RMIServerImpl(RMIServer.DEFAULT_HOST, 9999, RMIServer.DEFAULT_HOST, RMIServer.DEFAULT_PORT);
		Echo echo = client.getObject(Echo.class);
		System.out.println(echo.sayHello("飞飞"));
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("客户端2关闭.....");
			}
		});
		client.stop(true);
	}

}