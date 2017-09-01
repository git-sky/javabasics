package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.RemoteException;

public class EchoImpl implements Echo {

	public EchoImpl() throws RemoteException {
		super();
	}

	public String sayHello(String name) {
		return "Hello, " + name;
	}

}