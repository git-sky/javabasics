package cn.com.sky.rpc.simple_rpc_complex.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import cn.com.sky.rpc.simple_rpc_complex.RPC;
import cn.com.sky.rpc.simple_rpc_complex.local.ServerManager;
import cn.com.sky.rpc.simple_rpc_complex.protocal.Invocation;
import cn.com.sky.rpc.simple_rpc_complex.protocal.Method;
import cn.com.sky.rpc.simple_rpc_complex.protocal.Result;

/**
 * 服务监听器
 */
public class Listener extends Thread {

	/** 服务器socket */
	private ServerSocket socket;
	/** 服务器 */
	private Server server;

	public Listener(Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		String host = server.getHost();
		Integer port = server.getPort();
		port = port == null ? RPC.DEFAULT_RPC_PORT : port;
		System.out.println("启动服务器中，打开端口" + port);
		try {
			//创建服务器socket
			socket = host == null ? new ServerSocket(port) : new ServerSocket(server.getPort(), 50, InetAddress.getByName(host));
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		while (server.isRunning()) {
			ObjectInputStream ois = null;
			ObjectOutputStream oos = null;
			try {
				System.out.println("等待请求");
				Socket client = socket.accept();// 堵塞监听客户socket请求
				System.out.println("请求到来");
				ois = new ObjectInputStream(client.getInputStream());
				Invocation invo = (Invocation) ois.readObject();
				System.out.println("远程调用:" + invo);

				server.call(invo);

				Method method = invo.getMethod();
				if (invo.getInterfaces() == ServerManager.class && method.getMethodName().equals("stop") && invo.getResult() instanceof Result && ((Result) invo.getResult()).isStop()) {// 接收到关闭服务器命令
					server.stop();
				}
				oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(invo);
				oos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		try {
			if (socket != null && !socket.isClosed()) {
				System.out.println("正在关闭服务器...");
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}