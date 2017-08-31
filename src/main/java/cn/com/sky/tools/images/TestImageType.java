package cn.com.sky.tools.images;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//  JAVA对图片进行格式检查;
//  1)、判断文件的扩展名是否是要求的图片扩展名
//  不过这种方式非常的不妥，别人稍微的把一个不是图片的文件的扩展名修改为图片的扩展名，就绕开了你的这种校验。
//	2)、根据文件的前面几个字节
//  即常说的魔术数字进行判断 魔术数字，指定是文件的最开头的几个用于唯一区别其它文件类型的字节，有了这些魔术数字，我们就可以很方便的区别不同的文件
//  比如，一个JPEG文件，它开头的一些字节可能是类似这样的”ffd8 ffe0 0010 4a46 4946 0001 0101 0047
//  ……JFIF…..G“ 这里”ffd8“就表示了这个文件是一个JPEG类型的文件。
//  .jpg ff d8
//  .bmp 42 4d 
//  .gif 47 49 46 38 
//  .png 89 50 4e 47 
//  .bz 42 5a 
//  .zip 50 4b 03 04
//  但是这种判断方式也是非常不靠谱的，因为他只能够验证文件的前面几个字节，如此时有人把一个可执行的PHP文件的扩展名修改为PNG,然后再在前面补上”89
//  50″两个字节，就又绕开了这种验证方式。
//  3)、获取图片的宽高属性
//  如果能够正常的获取到一张图片的宽高属性，那肯定这是一张图片，因为非图片文件我们是获取不到它的宽高属性的;
//  4)、图片的安全检查。
//  通过判断确实是一张图片，可是如果是在一个可以正常浏览的图片文件中加入一些非法的代码
//  ，也将这张图片放于网页上打开，插入非法代码可能会被执行，杀毒软件（如AVAST）对这种修改是会报为病毒的。
//  可以对这个图片进地重写，给它增加水印或者对它进行resize操作，这样新生成的图片就不会再包含这样的恶意代码了。

public class TestImageType {

	public static void main(String[] args) throws IOException {

		// .jpg ff d8
		// .bmp 42 4d
		// .gif 47 49 46 38
		// .png 89 50 4e 47
		// .bz 42 5a
		// .zip 50 4b 03 04

		String[] str = new String[] { "a.jpg", "a.png","a.gif","a.bmp",
				"a.bz", "a.zip" };

		for (String s : str) {
			String imagePath = "f:\\" + s;
			System.out.println(imagePath);
			File image = new File(imagePath);
			InputStream is = new FileInputStream(image);
			// 读取两个byte
			byte[] bt = new byte[2];
			is.read(bt);
			System.out.println("前两个字节："+bytesToHexString(bt));// output 8950

			boolean b = isImage(image);
			System.out.println("是否是图片："+b);
		}
	}

	/**
	 * 读取图片前两个字节
	 */
	public static String bytesToHexString(byte[] src) {

		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}

		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;// byte to int
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 通过判断图片的宽度和高度来确定是否是图片
	 * 
	 * @param imageFile
	 * @return
	 */
	public static boolean isImage(File imageFile) {
		if (!imageFile.exists()) {
			return false;
		}
		Image img = null;
		try {
			img = ImageIO.read(imageFile);
			if (img == null || img.getWidth(null) <= 0
					|| img.getHeight(null) <= 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			img = null;
		}
	}
}
