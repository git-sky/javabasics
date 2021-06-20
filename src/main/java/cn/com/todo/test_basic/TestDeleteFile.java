package cn.com.todo.test_basic;
import java.io.File;

public class TestDeleteFile {
	public static void main(String args[]) {

		for (int i = 1; i <= 10; i++) {
			System.out.println(Math.pow(i, 0.1));
		}

		// Test t = new Test();
		// delFolder("C:/Users/sky/AppData/Local/Microsoft/Windows/Temporary Internet Files");
		// System.out.println("deleted");
	}

	// ɾ���ļ���
	// param folderPath �ļ�����������·��

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // ɾ����������������
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // ɾ�����ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ɾ��ָ���ļ����������ļ�
	// param path �ļ�����������·��
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
				System.out.println("�ļ�����:" + temp.getName());
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				// System.out.println("�ļ�����:"+temp.getName());
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// ��ɾ���ļ���������ļ�
				delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
				flag = true;
			}
		}
		return flag;
	}
}
