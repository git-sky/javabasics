package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.com.sky.rpc.rmi.rmi1.RMIServer;
import cn.com.sky.rpc.rmi.rmi1.RMIServerImpl;

public class MainServer {

	public static void main(String[] args) throws RemoteException, InstantiationException, IllegalAccessException, NotBoundException {
		RMIServer server = new RMIServerImpl(8888);
		server.registerRemoteObject(Hello.class, RemoteHello.class);
		server.registerRemoteObject(Echo.class, EchoImpl.class);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("服务端JVM关闭...");
			}
		});
		server.start();
	}

}