package cn.com.todo.test_basic;
import java.io.*;

public class TestRuntimeExecMac {
	public static void main(String[] args) {
		try {
			Process process = Runtime.getRuntime().exec("ipconfig /all");
			InputStreamReader ir = new InputStreamReader(process
					.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null)
				if (line.indexOf("�����ַ") > 0) {
					String MACAddr = line.substring(line.indexOf("-") + 1);
					System.out.println("MAC address = [" + MACAddr + "]");
				}
		} catch (IOException e) {
			System.err.println("IOException " + e.getMessage());
		}
	}
}