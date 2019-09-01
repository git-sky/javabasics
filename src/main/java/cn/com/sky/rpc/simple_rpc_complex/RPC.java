package cn.com.sky.rpc.simple_rpc_complex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import cn.com.sky.rpc.simple_rpc_complex.protocal.Invocation;
import cn.com.sky.rpc.simple_rpc_complex.support.Client;
import cn.com.sky.rpc.simple_rpc_complex.support.Listener;
import cn.com.sky.rpc.simple_rpc_complex.support.Server;

public class RPC {

	public static String DEFAULT_RPC_HOST = "127.0.0.1";
	public static int DEFAULT_RPC_PORT = 8888;
	public static int DEFAULT_TIMEOUT = 1000 * 60;// 一分钟

	public static <T> T getProxy(final Class<T> clazz, String host, int port) {
		return getProxy(clazz, host, port, DEFAULT_TIMEOUT);
	}

	public static <T> T getProxy(final Class<T> clazz, String host, int port, int timeout) {
		if (port < 0 || port > 0xFFFF) {// 0-65535
			throw new IllegalArgumentException("port out of range:" + port);
		}
		final Client client = new Client(host, port, timeout);
		InvocationHandler handler = new InvocationHandler() {// 代理调用实例

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Invocation invo = new Invocation();
				invo.setInterfaces(clazz);
				invo.setMethod(new cn.com.sky.rpc.simple_rpc_complex.protocal.Method(method.getName(), method.getParameterTypes()));
				invo.setParams(args);
				try {
					client.invoke(invo);
					return invo.getResult();
				} catch (Exception e) {
					throw e;
				} finally {
					if (client != null) {
						if (client.getOis() != null) {
							client.getOis().close();
						}
						if (client.getOos() != null) {
							client.getOos().close();
						}
						if (client.getSocket() != null && !client.getSocket().isClosed()) {
							client.getSocket().close();
						}
					}
				}
			}
		};
		T t = (T) Proxy.newProxyInstance(RPC.class.getClassLoader(), new Class[] { clazz }, handler);// 创建动态代理
		return t;
	}

	public static class RPCServer implements Server {
		private String host;
		private Integer port;
		private Listener listener;
		private boolean isRuning = true;
		private Map<String, Object> serviceEngine = new HashMap<String, Object>();

		public RPCServer(String host, Integer port) {
			if (port != null && (port < 0 || port > 0xFFFF)) {
				throw new IllegalArgumentException("port out of range:" + port);
			}
			this.host = host;
			this.port = port;
		}

		/**
		 * @param isRuning
		 *            the isRuning to set
		 */
		public void setRuning(boolean isRuning) {
			this.isRuning = isRuning;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		// 反射获取结果
		public void call(Invocation invo) {
			System.out.println(invo.getClass().getName());
			Object obj = serviceEngine.get(invo.getInterfaces().getName());
			if (obj != null) {
				try {
					Method m = obj.getClass().getMethod(invo.getMethod().getMethodName(), invo.getMethod().getParams());
					Object result = m.invoke(obj, invo.getParams());
					invo.setResult(result);
				} catch (Throwable th) {
					th.printStackTrace();
				}
			} else {
				throw new IllegalArgumentException("has no these class");
			}
		}

		public void register(Class<?> interfaceDefiner, Class<?> impl) {
			try {
				this.serviceEngine.put(interfaceDefiner.getName(), impl.newInstance());
				System.out.println("注册服务:" + serviceEngine);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void start() {
			System.out.println("启动服务器");
			listener = new Listener(this);
			this.isRuning = true;
			listener.start();
		}

		public void stop() {
			this.setRuning(false);
		}

		public boolean isRunning() {
			return isRuning;
		}

	}
}