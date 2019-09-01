//package cn.com.sky.tools.images;
//
///**
// * 利用javax.imageio包生成图片的基本用法
// */
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import com.sun.image.codec.jpeg.ImageFormatException;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//
//public class PictrueProess {
//	public void createImage(int x, int y, int month, int output)
//			throws IOException {
//		BufferedImage buf = new BufferedImage(600, 300,
//				BufferedImage.TYPE_INT_BGR);
//		Graphics2D g2 = buf.createGraphics();
//		g2.setPaint(Color.green); // 设好背景色
//		g2.fillRect(0, 0, 600, 300); // 把背景色弄成白的
//		g2.setPaint(Color.red); // 设置字体颜色
//		g2.drawRect(x, y, month, output); // 画1
//		g2.drawRect(x + 20, y, month, output + 20);// 画2
//		g2.drawRect(x + 40, y, month, output + 40);// 画3
//
//		g2.dispose(); // 清停
//
//		try {
//			ImageIO.write(buf, "jpg", new File("f:\\test.jpg"));
//			// 流 格式 文件位置和文件名字
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// 这段注释的是用sun提供的类来生成JPG图片
//		FileOutputStream outfile = null;
//		try {
//			outfile = new FileOutputStream("f:\\test2.jpg");
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}// 输出图片
//
//		JPEGImageEncoder jpge = JPEGCodec.createJPEGEncoder(outfile);
//		try {
//			jpge.encode(buf);
//		} catch (ImageFormatException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		PictrueProess p1 = new PictrueProess();
//		p1.createImage(100, 100, 20, 60);
//	}
//}