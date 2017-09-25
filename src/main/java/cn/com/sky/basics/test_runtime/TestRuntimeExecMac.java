package cn.com.sky.basics.test_runtime;

import java.io.*;

public class TestRuntimeExecMac {
	public static void main(String[] args) {
		try {
			Process process = Runtime.getRuntime().exec("ipconfig /all");
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null)
				if (line.indexOf("物理地址") > 0) {
					String MACAddr = line.substring(line.indexOf("-") + 1);
					System.out.println("MAC address = [" + MACAddr + "]");
				}
		} catch (java.io.IOException e) {
			System.err.println("IOException " + e.getMessage());
		}
	}
}