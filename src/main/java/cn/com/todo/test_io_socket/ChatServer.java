package cn.com.todo.test_io_socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	
	boolean started = false;
	ServerSocket ss = null;
	List<Client> clients = new ArrayList<Client>();
	//private Client c;

	public static void main(String[] args) {
		new ChatServer().start();
		}

	public void start() {
		try {
			ss = new ServerSocket(8888);		//������������
			started = true;						//�����ɹ���
		} catch (BindException e) {
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (started) {
				Socket s = ss.accept();			//�ȴ��ͻ��˽���
				Client c = new Client(s);		//ÿ����һ���ͻ��˽��룬�ͽ���һ��Client����
								//��ÿһ��Client�������clients�С�
				
				new Thread(c).start();			//������һ���̡߳�
				clients.add(c);							
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();					//�رշ�������
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Client implements Runnable {

		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		private Socket s;
		// private Client c;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;									//���ӳɹ���
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("A client connected");
		}

		public void send(String str) {
			try {
				//System.out.println(str);
				dos.writeUTF(str);
			} catch (IOException e) {
				//e.printStackTrace();
				//bConnected=false;
				clients.remove(this);
				System.out.println("�ҹ���Ľ����˳��ˣ��ұ���clients���Ƴ��ˣ�");
			
			}
		}

		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					for (int i = 0; i < clients.size(); i++) {
						Client c = clients.get(i);
						c.send(str);
					}
					System.out.println(str);
				}
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("A Client Closed!");
			} finally {
				try {
					if (dis != null)
						dis.close();
					if (dos != null)
						dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
