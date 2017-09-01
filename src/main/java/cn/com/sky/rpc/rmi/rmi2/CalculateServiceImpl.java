package cn.com.sky.rpc.rmi.rmi2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <pre>
 * 
 * 2.编写RMI接口的实现类
 * 
 * 实现上面的CalculateService比较简单，但是需要注意的是，我们必须让实现类继承java.rmi.server.UnicastRemoteObject类，
 * 此外，必须提供一个构造器，并且构造器必须抛出java.rmi.RemoteException异常。
 * 所以说，我们使用JVM提供的这一套RMI框架，就必须按照这些要求来实现，否则是无法成功发布RMI服务的。
 * 
 */
public class CalculateServiceImpl extends UnicastRemoteObject implements CalculateService {

	private static final long serialVersionUID = 1L;

	protected CalculateServiceImpl() throws RemoteException {
		super();
	}

	public int add(int a, int b) throws RemoteException {
		System.out.println("request from rmi client! a=" + a + " ,b=" + b);
		return a + b;
	}

}