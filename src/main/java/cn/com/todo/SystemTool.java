package cn.com.todo;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.InetAddress;

import java.net.UnknownHostException;

/**
 * 
 * @className: SystemTool
 * 
 * @description: ��ϵͳ��ص�һЩ���ù��߷���. Ŀǰʵ�ֵ��У���ȡMAC��ַ��IP��ַ��������
 * 
 * @author: Ц������
 * 
 * @createTime: 2010-11-13 ����08:03:44
 */

public class SystemTool {

	/**
	 * 
	 * ��ȡ��ǰ����ϵͳ����.
	 * 
	 * return ����ϵͳ���� ����:windows xp,linux ��.
	 */

	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 
	 * ��ȡunix������mac��ַ. ��windows��ϵͳĬ�ϵ��ñ�������ȡ.���������ϵͳ����������µ�ȡmac��ַ����.
	 * 
	 * @return mac��ַ
	 */

	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {

			process = Runtime.getRuntime().exec("ifconfig eth0");// linux�µ����һ��ȡeth0��Ϊ����������
			// ��ʾ��Ϣ�а�����mac��ַ��Ϣ
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("hwaddr");// Ѱ�ұ�ʾ�ַ���[hwaddr]
				if (index >= 0) {// �ҵ���
					mac = line.substring(index + "hwaddr".length() + 1).trim();// ȡ��mac��ַ��ȥ��2�߿ո�
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}

	/**
	 * 
	 * ��ȡwidnows������mac��ַ.
	 * 
	 * @return mac��ַ
	 */

	public static String getWindowsMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {

			process = Runtime.getRuntime().exec("ipconfig /all");// windows�µ������ʾ��Ϣ�а�����mac��ַ��Ϣ
			bufferedReader = new BufferedReader(new InputStreamReader(process
					.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {

				index = line.toLowerCase().indexOf("physical address");// Ѱ�ұ�ʾ�ַ���[physical
				// address]
				if (index >= 0) {// �ҵ���
					index = line.indexOf(":");// Ѱ��":"��λ��
					if (index >= 0) {
						mac = line.substring(index + 1).trim();// ȡ��mac��ַ��ȥ��2�߿ո�
					}
					break;
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bufferedReader != null) {

					bufferedReader.close();

				}

			} catch (IOException e1) {

				e1.printStackTrace();

			}

			bufferedReader = null;

			process = null;

		}

		return mac;

	}

	/**
	 * 
	 * @return ����������
	 */

	public static String getHostName() {

		InetAddress ia = null;

		try {

			ia = InetAddress.getLocalHost();

		} catch (UnknownHostException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		if (ia == null) {

			return "some error..";

		}

		else

			return ia.getHostName();

	}

	/**
	 * 
	 * @return ����IP ��ַ
	 */

	public static String getIPAddress() {

		InetAddress ia = null;

		try {

			ia = InetAddress.getLocalHost();

		} catch (UnknownHostException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		if (ia == null) {

			return "some error..";

		}

		else

			return ia.getHostAddress();

	}

	/**
	 * 
	 * �����õ�main����.
	 * 
	 * 
	 * 
	 * @param argc
	 * 
	 *            ���в���.
	 */

	public static void main(String[] argc) {

		String os = getOSName();

		System.out.println("OS Type:" + os);

		if (os.startsWith("windows")) {

			// ������windows

			String mac = getWindowsMACAddress();

			System.out.println("MAC Address:" + mac);

		} else {

			// �����Ƿ�windowsϵͳ һ�����unix

			String mac = getUnixMACAddress();

			System.out.println(mac);

		}

		System.out.println("HostName:" + getHostName());

		System.out.println("IPAddress:" + getIPAddress());

	}
}

// �������

// Map<String, String> map = System.getenv();
// String userName = map.get("USERNAME");// ��ȡ�û���
// String computerName = map.get("COMPUTERNAME");// ��ȡ�������
// String userDomain = map.get("USERDOMAIN");// ��ȡ���������