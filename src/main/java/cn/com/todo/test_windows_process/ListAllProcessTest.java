package cn.com.todo.test_windows_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListAllProcessTest {

	// �г����еĽ�����Ϣ
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Process proc = Runtime.getRuntime().exec("tasklist");
			br = new BufferedReader(
					new InputStreamReader(proc.getInputStream()));
			@SuppressWarnings("unused")
			String line = null;
			System.out.println("��ӡ�����������еĽ�����Ϣ");
			while ((line = br.readLine()) != null) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
