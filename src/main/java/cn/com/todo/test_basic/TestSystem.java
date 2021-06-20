package cn.com.todo.test_basic;
import java.io.File;

public class TestSystem {

	public static void main(String[] args) {
		// �жϵ�ǰϵͳ�Ƿ�֧��Java AWT Desktop��չ
	/*	if (java.awt.Desktop.isDesktopSupported()) {
			try {
				// ����һ��URIʵ��
				java.net.URI uri = java.net.URI.create("http://www.163.com/");
				// ��ȡ��ǰϵͳ������չ
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					// ��ȡϵͳĬ�������������
					dp.browse(uri);
				}
			} catch (java.lang.NullPointerException e) {
				// ��ΪuriΪ��ʱ�׳��쳣
				System.out.println("aaaaaaaaaaa");
			} catch (java.io.IOException e) {
				// ��Ϊ�޷���ȡϵͳĬ�������
				System.out.println("bbbbbbbbbbbbbb");

			}
		}*/

		//TestSystem a = new TestSystem();
		//boolean t = a.DeleteFolder("C:\\Users\\sky\\AppData\\Local\\Microsoft\\Windows\\Temporary Internet Files");

		//System.out.println("ɾ���ɹ���" + t);

	}

	public boolean DeleteFolder(String sPath) {
	
		boolean flag = false;
		File file = new File(sPath);
		// �ж�Ŀ¼���ļ��Ƿ����
		if (!file.exists()) { // �����ڷ��� false
			
			return flag;
			
		} else {
			
			// �ж��Ƿ�Ϊ�ļ�
			if (file.isFile()) { // Ϊ�ļ�ʱ����ɾ���ļ�����
				return deleteFile(sPath);
			} else { // ΪĿ¼ʱ����ɾ��Ŀ¼����
				return deleteDirectory(sPath);
			}
		}
	}

	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
	 * 
	 * @param sPath
	 *            ��ɾ��Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ�����true�����򷵻�false
	 */
	public boolean deleteDirectory(String sPath) {
		// ���sPath�����ļ��ָ�����β���Զ�����ļ��ָ���
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����µ������ļ�(������Ŀ¼)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // ɾ����Ŀ¼
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

}
