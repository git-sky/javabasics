package cn.com.sky.tools.images;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 */
public class ImageIOTest {

	/**
	 * Java Image I/O API 支持的读入，写出普通的格式，如果需要开发其它格式，还需要第三方插件，eg JIMI, JMagic
	 */
	public void formatImageNames() {

		String[] imageFormats = ImageIO.getReaderFormatNames();
		// [jpg, BMP, bmp, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
		System.out.println(Arrays.asList(imageFormats));

		String[] imageFormats1 = ImageIO.getWriterFormatNames();
		// [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
		System.out.println(Arrays.asList(imageFormats1));

	}

	/**
	 * Image I/O高级操作 ImageReader ImageWriter 通过ImageReader
	 * 可以获取图片信息而不用把整张图片数据都读入内存。
	 * 
	 * @throws IOException
	 */
	public void imageReaderOp() throws IOException {
		// 获取ImageReader
		Iterator<ImageReader> readers = ImageIO
				.getImageReadersByFormatName("JPG");
		ImageReader reader = readers.next();

		// 构造输入源
		File bigFile = new File("f:\\big.JPG");
		ImageInputStream iis = ImageIO.createImageInputStream(bigFile);
		// 输入源和ImageReader关联
		reader.setInput(iis, true);

		int imageIndex = 0;// imageIndex是文件（当包含多张图片时） 中图片的索引
		int width = reader.getWidth(imageIndex);
		int height = reader.getHeight(imageIndex);
		System.out.println("width:" + width);
		System.out.println("height:" + height);
	}

	/**
	 * 如果需要更多的控制，可以向read()方法传递一个ImageReadParam类型的参数。一个
	 * ImageReadParam对象可以让程序更好的利用内存。它不仅允许指定一个感兴趣的区域，还 可以指定一个抽样因子，用于向下采样。
	 * 例如，为了只解码图片的左上角的1/4，程序可以先获取一个合适的ImageReadParam对象：
	 * 
	 * @throws IOException
	 */
	public void imageReadParamOp() throws IOException {

		// 获取ImageReader
		Iterator<ImageReader> readers = ImageIO
				.getImageReadersByFormatName("JPG");
		ImageReader reader = readers.next();

		// 构造输入源
		File bigFile = new File("f:\\big.JPG");
		ImageInputStream iis = ImageIO.createImageInputStream(bigFile);
		reader.setInput(iis, true);

		// 获取一个合适的ImageReadParam对象
		ImageReadParam irp = reader.getDefaultReadParam();
		// 指定图片区域
		int imageIndex = 0;
		int halfWidth = reader.getWidth(imageIndex) / 2;
		int halfHeight = reader.getHeight(imageIndex) / 2;
		Rectangle rect = new Rectangle(0, 0, halfWidth, halfHeight);
		irp.setSourceRegion(rect);
		// 读取图片
		BufferedImage bi = reader.read(imageIndex, irp);
		// 写入图片
		ImageIO.write(bi, "JPG", new File("f:\\big_half.JPG"));
	}

	/**
	 * 图片元信息
	 * 
	 * @throws IOException
	 */
	public void ImageMetadata() throws IOException {

		int imageIndex = 0;
		Iterator<ImageReader> readers = ImageIO
				.getImageReadersByFormatName("JPG");
		ImageReader reader = readers.next();

		File bigFile = new File("f:\\big.JPG");
		ImageInputStream iis = ImageIO.createImageInputStream(bigFile);
		reader.setInput(iis, true);

		IIOMetadata metadata = reader.getImageMetadata(imageIndex);
		String[] str = metadata.getMetadataFormatNames();
		for (String s : str) {
			System.out.println(s);
		}
	}

	/**
	 * 生成缩略图
	 * 
	 */
	public void generateSmall() throws IOException {
		File bigFile = new File("f:\\big.JPG");
		Image image = ImageIO.read(bigFile);
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		BufferedImage buffi = new BufferedImage(width / 2, height / 2,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = buffi.getGraphics();
		g.drawImage(image, 0, 0, width / 2, height / 2, null);
		g.dispose();
		ImageIO.write(buffi, "JPG", new File("f:\\small.JPG"));

	}

	public static void main(String[] args) throws IOException {
		ImageIOTest iot = new ImageIOTest();
		// iot.generateSmall();//缩略图
		// iot.formatImageNames();
		// iot.imageReaderOp();
		// iot.imageReadParamOp();
		iot.ImageMetadata();
	}

}
