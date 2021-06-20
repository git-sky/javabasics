package cn.com.qr;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public class TestQR {

    private static int width = 935;
    private static int height = 935;

    private static final String FORMAT_NAME = "JPG";
    private static final String destPath = "/Users/xxxx/Downloads/temp";

    private static int margin = 0;   //白边大小，取值范围0~4
    private static ErrorCorrectionLevel level = ErrorCorrectionLevel.H;  //二维码容错率


    public static void main(String[] args) {
        try {
            BufferedImage bufferedImage = encode("https://www.baidu.com", 100, 100);
            String fileName = new Random().nextInt(99999999) + ".jpg";
            File file = new File(destPath + "/" + fileName);

            ImageIO.write(bufferedImage, FORMAT_NAME, file);

            BufferedImage image = ImageIO.read(file);
            String result = decode(image);
            System.out.println(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成二维码
     *
     * @param content
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static BufferedImage encode(String content, int width, int height) throws WriterException {
        Map<EncodeHintType, Object> encodeHints = new HashMap<EncodeHintType, Object>();
        encodeHints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        encodeHints.put(EncodeHintType.MARGIN, margin);
        encodeHints.put(EncodeHintType.ERROR_CORRECTION, level);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, encodeHints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }


    public static String decode(BufferedImage bufferedImage) throws NotFoundException {
        MultiFormatReader formatReader = new MultiFormatReader();

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

        //定义二维码的参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        Result result = formatReader.decode(binaryBitmap, hints);
        return result.getText();
    }
}