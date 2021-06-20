//package cn.com.qr;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.common.BitMatrix;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.util.Objects;
//
///**
// *
// */
//public class Test {
//
//    public static void main(String[] args) {
//
//    }
//
//    public static File drawLogoQRCodeWithBackGround(File logoFile, String qrUrl, String name, File backGroundFile, int side, int xOffect, int yOffect) throws Exception {
//
//        File folder = new File(UploadTempFileDirectory);
//        if (!folder.exists()) {
//            folder.mkdirs();
//        }
//
//        int width = 0;
//        int height = 0;
//
//        if (side > 0) {
//            width = side;
//            height = side;
//        } else {
//            width = 1000;
//            height = 1000;
//        }
//
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
//        BitMatrix bm = multiFormatWriter.encode(qrUrl, BarcodeFormat.QR_CODE, width, height, hints);
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
//        for (int x = 0; x < width; x++) {
//            for (int y = 0; y < height; y++) {
//                image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
//            }
//        }
//
//        if (Objects.nonNull(logoFile) && logoFile.exists()) {
//            // 构建绘图对象
//            Graphics2D g = image.createGraphics();
//            // 读取Logo图片
//            Image src = Toolkit.getDefaultToolkit().getImage(logoFile.getPath());
//            BufferedImage logo = toBufferedImage(src);
//            // 开始绘制logo图片
//            g.drawImage(logo, width * 3 / 10, height * 3 / 10, width * 4 / 10, height * 4 / 10, null);
//            g.dispose();
//            logo.flush();
//
//        }
//        image.flush();
//        if (Objects.nonNull(backGroundFile) && backGroundFile.exists()) {
//            // 读取背景图片
//            Image src = Toolkit.getDefaultToolkit().getImage(backGroundFile.getPath());
//            BufferedImage backGround = toBufferedImage(src);
//
//            Graphics2D g = backGround.createGraphics();
//            g.drawImage(image, xOffect, yOffect, null);
//            g.dispose();
//            backGround.flush();
//            File localFile = new File(UploadTempFileDirectory + name + ".jpg");
//            ImageIO.write(backGround, "jpg", localFile);
//            return localFile;
//        }
//        File localFile = new File(UploadTempFileDirectory + name + ".jpg");
//        ImageIO.write(image, "jpg", localFile);
//        return localFile;
//    }
//
//    public static BufferedImage toBufferedImage(Image image) {
//        if (image instanceof BufferedImage) {
//            return (BufferedImage) image;
//        }
//        // This code ensures that all the pixels in the image are loaded
//        image = new ImageIcon(image).getImage();
//        BufferedImage bimage = null;
//        GraphicsEnvironment ge = GraphicsEnvironment
//                .getLocalGraphicsEnvironment();
//        try {
//            int transparency = Transparency.OPAQUE;
//            GraphicsDevice gs = ge.getDefaultScreenDevice();
//            GraphicsConfiguration gc = gs.getDefaultConfiguration();
//            bimage = gc.createCompatibleImage(image.getWidth(null),
//                    image.getHeight(null), transparency);
//        } catch (HeadlessException e) {
//            // The system does not have a screen
//        }
//        if (bimage == null) {
//            // Create a buffered image using the default color model
//            int type = BufferedImage.TYPE_INT_RGB;
//            bimage = new BufferedImage(image.getWidth(null),
//                    image.getHeight(null), type);
//        }
//        // Copy image to buffered image
//        Graphics g = bimage.createGraphics();
//        // Paint the image onto the buffered image
//        g.drawImage(image, 0, 0, null);
//        g.dispose();
//        return bimage;
//    }
//
//}