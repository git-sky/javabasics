package cn.com.todo.test_nio_socket;

import java.net.*;
import java.nio.channels.*;
import java.util.*;
import java.io.*;

public class TestNIOSocket {
	private static final int CLINET_PORT = 10200;
	private static final int SEVER_PORT = 10201;
	// �������������׽��ֵĿ�ѡ��ͨ��
	private static SocketChannel ch;
	// ͨ��ѡ����
	private static Selector sel;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// ���׽���ͨ��
		ch = SocketChannel.open();
		// ��һ��ͨ��ѡ����
		sel = Selector.open();
		try {
			// ��ȡ���׽���ͨ���������׽��֣��������׽��ְ󶨵�����ָ���˿�
			ch.socket().bind(new InetSocketAddress(CLINET_PORT));
			// ������ͨ��Ϊ������ģʽ
			ch.configureBlocking(false);
			// Ϊͨ��ѡ����ע��ͨ������ָ��������ѡ�����
			ch.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE
					| SelectionKey.OP_CONNECT);
			// ѡ��ͨ����ע����¼�������Ӧͨ����ΪI/O����׼������
			sel.select();
			// ����ѡ��������ѡ�����
			Iterator it = sel.selectedKeys().iterator();
			while (it.hasNext()) {
				// ��ȡͨ����ѡ�����ļ�
				SelectionKey key = (SelectionKey) it.next();
				it.remove();
				// �����ͨ���Ѿ�׼�����׽�������
				if (key.isConnectable()) {
					InetAddress addr = InetAddress.getLocalHost();
					System.out.println("Connect will not block");
					// ���ô˷�������һ�������������Ӳ�������������������ӣ���˷���//����true.���򷵻�false,�ұ������Ժ�ʹ��finishConnect()������Ӳ���
					// �˴������ͷ���˵�Socket����
					if (!ch.connect(new InetSocketAddress(addr, SEVER_PORT))) {
						// ��ɷ��������Ӳ���
						ch.finishConnect();
					}
				}
				// ��ͨ����׼���ý��ж�ȡ
				if (key.isReadable()) {
					System.out.println("Read will not block");
				}
				// ��ͨ����׼���ý���д��
				if (key.isWritable()) {
					System.out.println("Write will not block");
				}
			}
		} finally {
			ch.close();
			sel.close();
		}
	}
}
