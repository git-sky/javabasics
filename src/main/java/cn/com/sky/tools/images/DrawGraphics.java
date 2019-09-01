//package cn.com.sky.tools.images;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
///**
// *
// *
// * Java 2D API分为以下几个包
// java.awt.geom
// 提供用于在与二维几何形状相关的对象上定义和执行操作的 Java 2D 类。
// Area 对象存储和操作2维空间封闭区域的与解析无关的描述。
// public Rectangle getBounds() 返回完全包围此 Area 的边界 Rectangle。
// public boolean contains(double x, double y)  测试指定坐标是否在 Shape 的边界内。
// 对区域进行加、减、交和异或。
// public void add(Area rhs)
// public void subtract(Area rhs)
// public void intersect(Area rhs)
// public void exclusiveOr(Area rhs)
// java.awt.font 字体类
// Font f = new Font(String name,int style,int size);//style Font.ITALIC
// java.awt.color  颜色定义和颜色调优
// java.awt.image 用于图像定义
// java.awt.image.renderable  图像渲染
// java.awt.print
// java.awt.Graphics2D
// 以提供如何绘制图形的信息，包含六个属性
// 绘制 paint    作用在边线和填充上
// 画笔 stroke   描边决定着图形或文字的轮廓，边缘即可以是粗细不等的实线，也可以是等宽点线
// 字体 font     所有的文本都使用能表现文字的样式图形渲染
// 转换 transform 图形在渲染前可能会进行一步或多步的变形 图形可能被移动，旋转或拉伸
// 剪切 clip
// 合成 composite
// javax.imageio
// Java高级图像处理图像I/O工具包
// eg; java2D绘制直线，矩形，椭圆
// */
//
///**
// *
// * Description java2D绘制直线，矩形，椭圆，旋转图形
// *
// */
//public class DrawGraphics {
//
//	private BufferedImage image;
//
//	private Graphics2D graphics;
//
//	public static void main(String[] args) throws IOException {
//		DrawGraphics dg = new DrawGraphics();
//		dg.drawLine();
//		dg.drawRect();
//		dg.drawEllipse();
//	}
//
//	public void init() {
//		int width = 480, hight = 720;
//		image = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
//		// 获取图形上下文
//		graphics = (Graphics2D) image.getGraphics();
//	}
//
//	/**
//	 * 创建一个(x1,y1)到(x2,y2)的Line2D对象
//	 */
//	public void drawLine() throws IOException {
//		init();
//		Line2D line = new Line2D.Double(2, 2, 300, 300);
//		graphics.setColor(Color.red);//着色
//		graphics.draw(line);
//		graphics.dispose();
//		outImage("PNG", "D:\\Line.PNG");
//	}
//
//	/**
//	 * 创建一个左上角坐标是(50,50)，宽是300，高是400的一个矩形对象
//	 */
//	public void drawRect() throws IOException {
//		init();
//		Rectangle2D rect = new Rectangle2D.Double(50, 50, 400, 400);
//		graphics.setColor(Color.green);
//		graphics.draw(rect);
//		graphics.fill(rect);
//		graphics.dispose();
//		outImage("PNG", "D:\\Rect.PNG");
//	}
//
//	/**
//	 * 创建了一个左上角坐标是(50,50)，宽是300，高是200的一个椭圆对象,如果高，宽一样，则是一个标准的圆
//	 */
//	public void drawEllipse() throws IOException {
//		init();
//		Ellipse2D ellipse = new Ellipse2D.Double(50, 50, 300, 200);
//		graphics.draw(ellipse);
//		graphics.fill(ellipse);
//		graphics.dispose();
//		outImage("PNG", "D:\\ellipse.PNG");
//	}
//
//	/**
//	 * 输出绘制的图形
//	 *
//	 * @param type
//	 * @param filePath
//	 */
//	public void outImage(String type, String filePath) throws IOException {
//		ImageIO.write(image, type, new File(filePath));
//	}
//
//}