package cn.com.sky.rpc.rmi.rmi1;

import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI服务器接口
 */
public interface RMIServer extends Remote, Serializable {

	static String DEFAULT_HOST = "127.0.0.1";
	static int DEFAULT_PORT = 8888;

	/**
	 * 注册本地对象
	 * 
	 * @param interfaceDefiner
	 * @param impl
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void registerLocalObject(Class<?> interfaceDefiner, Class<?> impl) throws RemoteException, InstantiationException, IllegalAccessException;

	/**
	 * 注册远程对象
	 * 
	 * @param interfaceDefiner
	 * @param impl
	 * @throws RemoteException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void registerRemoteObject(Class<?> interfaceDefiner, Class<?> impl) throws RemoteException, InstantiationException, IllegalAccessException;

	/**
	 * 卸载指定对象
	 * 
	 * @param interfaceDefiner
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 */
	public void unregisterObject(Class<?> interfaceDefiner) throws RemoteException, NotBoundException, ClassNotFoundException;

	/**
	 * 卸载所有对象
	 * 
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 */
	public void unregisterAllObjects() throws AccessException, RemoteException, NotBoundException, ClassNotFoundException;

	/**
	 * 获取对象
	 * 
	 * @param interfaceDefiner
	 * @return
	 */
	public <T> T getObject(Class<T> interfaceDefiner) throws RemoteException;

	/**
	 * 启动服务
	 * 
	 * @throws RemoteException
	 */
	public void start() throws RemoteException;

	/**
	 * 关闭服务器
	 * 
	 * @param remote
	 *            是否同时关闭远程RMI服务
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws ClassNotFoundException
	 */
	public void stop(boolean remote) throws AccessException, RemoteException, NotBoundException, ClassNotFoundException;

	/**
	 * 关闭远程服务
	 * 
	 * @throws RemoteException
	 */
	public void remoteStop() throws RemoteException;

	/**
	 * 判断服务器运行状态
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public boolean isRunning() throws RemoteException;
}