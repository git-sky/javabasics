package cn.com.todo.test_io_socket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();

	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bConnected = false;

	Thread tRecv = new Thread(new RecvThread()); // ����һ���̡߳�

	public static void main(String args[]) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(WIDTH, HEIGHT);
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
		connect();
		tRecv.start();
	}

	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8889); // ���ӷ�������
			System.out.println("Connected to the Server");
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			bConnected = true; // ���ӳɹ���
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			bConnected = false;
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class TFListener implements ActionListener { // �ڲ������ࡣ

		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			// taContent.setText(str);
			tfTxt.setText("");

			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private class RecvThread implements Runnable {
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					// System.out.println(str);
					taContent.setText(taContent.getText() + str + '\n');
				}
			} catch (SocketException e) {
				System.out.println("���˳��ˣ�Bye Bye��");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
