package cn.com.sky.basics.test_file;

import java.io.File;

public class TestSystem {

    public static void main(String[] args) {
        // 判断当前系统是否支持Java AWT Desktop扩展
	/*	if (java.awt.Desktop.isDesktopSupported()) {
			try {
				// 创建一个URI实例
				java.net.URI uri = java.net.URI.create("http://www.163.com/");
				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					// 获取系统默认浏览器打开链接
					dp.browse(uri);
				}
			} catch (java.lang.NullPointerException e) {
				// 此为uri为空时抛出异常
				System.out.println("aaaaaaaaaaa");
			} catch (java.io.IOException e) {
				// 此为无法获取系统默认浏览器
				System.out.println("bbbbbbbbbbbbbb");

			}
		}*/

        //TestSystem a = new TestSystem();
        //boolean t = a.DeleteFolder("C:\\Users\\sky\\AppData\\Local\\Microsoft\\Windows\\Temporary Internet Files");

        //System.out.println("删除成功：" + t);

    }

    public boolean DeleteFolder(String sPath) {

        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) { // 不存在返回 false

            return flag;

        } else {

            // 判断是否为文件
            if (file.isFile()) { // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else { // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }

    public boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 删除目录（文件夹）以及目录下的文件
     *
     * @param sPath 被删除目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public boolean deleteDirectory(String sPath) {
        // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            } // 删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag)
            return false;
        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

}
