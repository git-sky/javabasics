package cn.com.sky.basics.test_file;

import java.io.File;
/**
 * 
 * 列出文件夹下的文件
 *
 */
public class listFiles {
	public static void main(String arg[]) {
		String dir = "src/test";
		File[] files = new File(dir).listFiles();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory())
				list(files[i].listFiles());
			else
				System.out.println(files[i].getName());
		}
	}

	public static void list(File[] files) {
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory())
				list(files[i].listFiles());
			else
				System.out.println(files[i].getName());
		}
	}
}
