package cn.com.sky.rpc.rmi.rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <pre>
 * 
 * 1.定义一个RMI接口
 * 
 * RMI接口实际上还是一个普通的Java接口，只是RMI接口必须继承java.rmi.Remote，
 * 此外，RMI接口内的每个方法必须声明抛出一个java.rmi.RemoteException异常。
 * 
 * 继承了Remote接口，实际上就是让JVM知道该接口需要用于远程调用的，抛出RemoteException是为了让调用RMI服务的程序捕获这个异常根据相应异常情况进行后续处理，毕竟远程调用过程中，什么奇怪的事情都有可能发生（如：断网）。
 * 需要说明的是，RemoteException是一个”受检异常“，在调用的时候必须使用try...catch...自行处理。
 * 
 */
public interface CalculateService extends Remote {

	public int add(int a, int b) throws RemoteException;
}