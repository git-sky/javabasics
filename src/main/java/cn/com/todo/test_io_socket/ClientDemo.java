package cn.com.todo.test_io_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 8888);
			// ��ȡ����������ڿͻ�����������˷�������
			DataOutputStream dos = new DataOutputStream(socket
					.getOutputStream());
			// ��ȡ�����������ڽ��շ������˷�����������
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// �ͻ�����������˷�������
			dos.writeUTF("���ǿͻ��ˣ���������!");
			// ��ӡ���ӷ������˽��յ�������
			System.out.println(dis.readUTF());
			// ����Ҫ����ʹ�ô�����ʱ���ǵùر�Ŷ
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}