package cn.com.todo;

public class IpTest {

	public static void main(String args[]) {
		String ipAddress="192.168.1.1";
		long ip=new IpTest().ipToInt(ipAddress);
		System.out.println("��"+ip+"��");
	}

	private long ipToInt(String ip) {
		String[] arr = ip.split("\\.");
		//System.out.println("��"+arr.length+"��");
		long ret = 0;
		for (int i = 0; i < arr.length; i++) {
			long l = 1;
			for (int j = 0; j < i; j++) {
				l *= 256;
			}
			try {
				ret += Long.parseLong(arr[arr.length - i - 1]) * l;
				//System.out.println("��ret="+ret+"��");
			} catch (Exception e) {
				ret += 0;
			}
		}
		return ret;
	}

}
