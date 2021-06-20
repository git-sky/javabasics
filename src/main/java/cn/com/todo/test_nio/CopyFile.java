package cn.com.todo.test_nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel�޷�����Ϊ������ģʽ������������������ģʽ�¡�
 * @author zxp
 */

public class CopyFile {
	public static void main(String[] args) throws Exception {
		String infile = "f:\\copy.sql";
		String outfile = "f:\\copy.txt";
		// ��ȡԴ�ļ���Ŀ���ļ������������
		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);
		// ��ȡ�������ͨ��
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		// ����������
		ByteBuffer buffer = ByteBuffer.allocate(1024);//allocate() ��������һ������ָ����С�ĵײ����飬��������װ��һ��������������
		while (true) {
			// clear�������軺������ʹ�����Խ��ܶ��������
			buffer.clear();
			// ������ͨ���н����ݶ���������
			int r = fcin.read(buffer);
			// read�������ض�ȡ���ֽ���������Ϊ�㣬�����ͨ���ѵ�������ĩβ���򷵻�-1
			if (r == -1) {
				break;
			}
			// flip�����û��������Խ��¶��������д����һ��ͨ��
			buffer.flip();
			// �ӻ�����������д�����ͨ����
			fcout.write(buffer);
		}
	}
}