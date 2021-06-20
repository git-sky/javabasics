package cn.com.todo.test_windows_process;

import java.io.IOException;

public class RunProcessTest2 {

	public static void main(String[] args) {
		try {
			Process proc = Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}