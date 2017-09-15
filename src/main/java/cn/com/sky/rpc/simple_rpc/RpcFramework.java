package cn.com.sky.rpc.simple_rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * RPC框架
 */
public class RpcFramework {
	static ServerSocket server = null;
	static Map<String, Object> serviceMap = new HashMap<String, Object>();

	/**
	 * 暴露服务
	 * 
	 * @param <C>
	 * 
	 * @param service
	 *            服务实现
	 * @param port
	 *            服务端口
	 * @throws Exception
	 */
	public static <C> void export(final Object service, final int port) throws Exception {
		if (service == null) {
			throw new IllegalArgumentException("service instance == null");
		}
		if (port <= 0 || port > 65535) {
			throw new IllegalArgumentException("Invalid port " + port);
		}
		System.out.println("Export service " + service.getClass().getName() + " on port " + port);

		if (server == null) {
			server = new ServerSocket(port);
		} else if (server.getLocalPort() != port) {
			server = new ServerSocket(port);
		}

		Class<Object>[] classs = (Class<Object>[]) service.getClass().getInterfaces();
		for (Class<Object> c : classs) {
			serviceMap.put(c.getName() + "|" + port, service);
		}

		new Thread(new Runnable() {// 创建后台线程进行socket监听
					public void run() {
						while (true) {
							try {
								// 1.网络连接
								final Socket socket = server.accept();
								try {
									try {
										// 2.反序列化
										ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
										try {
											// 3.协议解析
											String interfaceName = input.readUTF();// 客户端调用的接口
											String methodName = input.readUTF();// service是服务器端提供服务的对象，但是，要通过获取到的调用方法的名称，参数类型，以及参数来选择对象的方法，并调用。获得方法的名称
											Class<?>[] parameterTypes = (Class<?>[]) input.readObject();// 获得参数的类型
											Object[] arguments = (Object[]) input.readObject();// 获得参数
											// 4.路由找到服务
											Object remoter = RpcFramework.getService(interfaceName + "|" + port);
											ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
											try {
												// 5.反射得到结果
												Method method = remoter.getClass().getMethod(methodName, parameterTypes);// 通过反射机制获得方法
												Object result = method.invoke(remoter, arguments);// 通过反射机制获得类的方法，并调用这个方法
												output.writeObject(result);// 将结果发送
											} catch (Throwable t) {
												output.writeObject(t);
											} finally {
												output.close();
											}
										} finally {
											input.close();
										}
									} finally {
										socket.close();
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}

				}).start();
	}

	/**
	 * 引用服务
	 * 
	 * @param <T>
	 *            接口泛型
	 * @param interfaceClass
	 *            接口类型
	 * @param host
	 *            服务器主机名
	 * @param port
	 *            服务器端口
	 * @return 远程服务
	 * @throws Exception
	 */
	// 原理是通过代理，获得服务器端接口的一个“代理”的对象。对这个对象的所有操作都会调用invoke函数，在invoke函数中，是将被调用的函数名，参数列表和参数发送到服务器，并接收服务器处理的结果
	@SuppressWarnings("unchecked")
	public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
		if (interfaceClass == null) {
			throw new IllegalArgumentException("Interface class == null");
		}
		if (!interfaceClass.isInterface()) {
			throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
		}
		if (host == null || host.length() == 0) {
			throw new IllegalArgumentException("Host == null!");
		}
		if (port <= 0 || port > 65535) {
			throw new IllegalArgumentException("Invalid port " + port);
		}
		System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);

		// 动态代理（jdk原生，javassist，cglib等）
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass }, new InvocationHandler() {// jdk动态代理,内部类
					public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
						// 1.网络连接（jdk原生，netty，mina等），IO通信模型（两种模型：BIO，NIO）
						Socket socket = new Socket(host, port);
						try {
							// 2.序列化(jdk原生、kryo、hessian、protobuf、thrift、avro等)
							ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
							try {
								// 3.协议编码(消息数据结构)
								output.writeUTF(interfaceClass.getName());// 接口名
								output.writeUTF(method.getName());// 方法名
								output.writeObject(method.getParameterTypes());// 参数类型
								output.writeObject(arguments);// 参数

								ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
								try {
									Object result = input.readObject();
									if (result instanceof Throwable) {
										throw (Throwable) result;
									}
									return result;
								} finally {
									input.close();
								}
							} finally {
								output.close();
							}
						} finally {
							socket.close();
						}
					}
				});
	}

	private static Object getService(String name) {
		return serviceMap.get(name);
	}
}