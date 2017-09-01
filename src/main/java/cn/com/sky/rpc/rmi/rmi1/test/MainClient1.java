package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.com.sky.rpc.rmi.rmi1.RMIServer;
import cn.com.sky.rpc.rmi.rmi1.RMIServerImpl;

public class MainClient1 {

	public static void main(String[] args) throws RemoteException, NotBoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
		RMIServer client = new RMIServerImpl(RMIServer.DEFAULT_HOST, 9998, RMIServer.DEFAULT_HOST, RMIServer.DEFAULT_PORT);
		Hello hello = client.getObject(Hello.class);
		System.out.println(hello.sayHello("ljf"));

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("客户端1关闭.....");
			}
		});
		client.stop(false);
	}

}