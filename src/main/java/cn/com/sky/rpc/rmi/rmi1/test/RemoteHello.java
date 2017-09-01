package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteHello extends UnicastRemoteObject implements Hello {

	public RemoteHello() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	public String sayHello(String name) throws RemoteException {
		return "Hello, " + name;
	}

}