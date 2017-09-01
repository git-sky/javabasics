package cn.com.sky.rpc.rmi.rmi1;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * RMI服务监听器,编写一个监听器用于监听服务器.
 */
public class Listener extends Thread {

	private RMIServer server;

	public Listener(RMIServer server) {
		this.server = server;
	}

	public void run() {
		System.out.println("RMI服务器启动...");
		try {
			while (server.isRunning()) {

			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			server.stop(false);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}