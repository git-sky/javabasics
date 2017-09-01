package cn.com.sky.rpc.simple_rpc2.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import cn.com.sky.rpc.simple_rpc2.protocal.Invocation;

public class Client {
	private String host;
	private int port;
	private int timeout;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Client(String host, int port, Integer timeout) {
		this.host = host;
		this.port = port;
		this.timeout = timeout;
	}

	public void init() throws UnknownHostException, IOException {
		SocketAddress socketaddress = new InetSocketAddress(host, port);
		socket = new Socket();// 创建socket
		socket.connect(socketaddress, timeout);
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	public void invoke(Invocation invo) throws UnknownHostException, IOException, ClassNotFoundException {
		init();
		System.out.println("发送请求");
		Invocation result = null;
		try {
			oos.writeObject(invo);
			oos.flush();
			ois = new ObjectInputStream(socket.getInputStream());

			result = (Invocation) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		invo.setResult(result.getResult());
	}

}