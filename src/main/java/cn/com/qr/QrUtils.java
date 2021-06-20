package cn.com.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * 生成二维码与转换二维码为base64字符串
 */
public class QrUtils {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private static int margin = 0;   //白边大小，取值范围0~4
    private static ErrorCorrectionLevel level = ErrorCorrectionLevel.H;  //二维码容错率

    private static final String format = "jpg";// 二维码的图片格式

    public static BitMatrix encode(String content, int width, int height) throws WriterException {
        Map<EncodeHintType, Object> encodeHints = new HashMap<EncodeHintType, Object>();
        encodeHints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        encodeHints.put(EncodeHintType.MARGIN, margin);
        encodeHints.put(EncodeHintType.ERROR_CORRECTION, level);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, encodeHints);
        return bitMatrix;
    }


    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static InputStream toInputStream(BufferedImage image) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, format, os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    /**
     * 根据图片地址转换为base64编码字符串
     */
    public static String getImageBase64Str(InputStream inputStream) {
        byte[] data = null;
        try {
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static void writeToFile(BufferedImage image, String format, File file)
            throws IOException {
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format "
                    + format + " to " + file);
        }
    }

    public static void writeToStream(BufferedImage image, String format,
                                     OutputStream stream) throws IOException {
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }


    public static void main(String[] args) throws Exception {
        try {
            BitMatrix bitMatrix = encode("http://www.baidu.com", 200, 200);

            BufferedImage image = toBufferedImage(bitMatrix);

            //base64
            InputStream is = toInputStream(image);
            String imageBase64Str = getImageBase64Str(is);
            System.out.println(imageBase64Str);

            //url
            File outputFile = new File("/Downloads/temp/a.jpg");
            writeToFile(image, format, outputFile);

        } catch (Exception e) {
            System.out.println("异常==" + e.getMessage());
            e.printStackTrace();
        }
    }

}