package cn.com.todo.test_io_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	/**
	 * ע�⣺Socket�ķ������������Ҫͬ�����еģ����ͻ��˷���һ����Ϣ�������������Ƚ���������Ϣ��
	 * ����ſ�����ͻ��˷�����Ϣ�����򽫻�������ʱ����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			// ���������յ��ͻ��˵����ݺ󣬴�����˿ͻ��˶Ի���Socket
			Socket socket = ss.accept();
			// ������ͻ��˷������ݵ������
			DataOutputStream dos = new DataOutputStream(socket
					.getOutputStream());
			// ���ڽ��տͻ��˷��������ݵ�������
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println("���������յ��ͻ��˵���������" + dis.readUTF());
			// ��������ͻ��˷������ӳɹ�ȷ����Ϣ
			dos.writeUTF("���������������ӳɹ�!");
			// ����Ҫ����ʹ�ô�����ʱ���ر�����
			socket.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}