package cn.com.sky.rpc.rmi.rmi1.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

	public String sayHello(String name) throws RemoteException;
}