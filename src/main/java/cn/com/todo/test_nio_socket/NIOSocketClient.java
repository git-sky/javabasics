package cn.com.todo.test_nio_socket;

import java.net.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class NIOSocketClient {
	private static final int CLIENT_PORT = 10200;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		Selector sel = Selector.open();
		try {
			sc.configureBlocking(false);
			sc.socket().bind(new InetSocketAddress(CLIENT_PORT));
			sc.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE
					| SelectionKey.OP_CONNECT);
			int i = 0;
			boolean written = false;
			boolean done = false;
			String encoding = System.getProperty("file.encoding");
			Charset cs = Charset.forName(encoding);
			ByteBuffer buf = ByteBuffer.allocate(16);
			while (!done) {
				sel.select();
				Iterator it = sel.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					it.remove();
					// ��ȡ����ͨ��ѡ�����¼������׽���ͨ��
					sc = (SocketChannel) key.channel();
					// ��ǰͨ��ѡ�������������Ѿ�׼�������¼������ҿͻ����׽���
					// ͨ����δ���ӵ�������׽���ͨ��
					if (key.isConnectable() && !sc.isConnected()) {
						InetAddress addr = InetAddress.getByName(null);
						// �ͻ����׽���ͨ���������׽���ͨ���������������
						boolean success = sc.connect(new InetSocketAddress(
								addr, NIOSocketServer.PORT));
						// ����ͻ���û���������ӵ�����ˣ���ͻ�����ɷ��������Ӳ���
						if (!success)
							sc.finishConnect();
					}
					// ���ͨ��ѡ����������ȡ������׼�����¼������Ѿ���ͨ��д������
					if (key.isReadable() && written) {
						if (sc.read((ByteBuffer) buf.clear()) > 0) {
							written = false;
							// ���׽���ͨ���ж�ȡ����
							String response = cs
									.decode((ByteBuffer) buf.flip()).toString();
							System.out.println(response);
							if (response.indexOf("END") != -1)
								done = true;
						}
					}
					// ���ͨ��ѡ��������д�������׼�����¼���������δ��ͨ��д������
					if (key.isWritable() && !written) {
						// ���׽���ͨ����д������
						if (i < 10)
							sc.write(ByteBuffer.wrap(new String("howdy " + i
									+ "\n").getBytes()));
						else if (i == 10)
							sc.write(ByteBuffer.wrap(new String("END")
									.getBytes()));
						written = true;
						i++;
					}
				}
			}
		} finally {
			sc.close();
			sel.close();
		}
	}
}