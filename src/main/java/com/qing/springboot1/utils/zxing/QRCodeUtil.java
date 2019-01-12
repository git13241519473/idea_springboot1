package com.qing.springboot1.utils.zxing;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
 
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 
/**
 * 二维码生成工具类
 */
public final class QRCodeUtil extends LuminanceSource {
 
    private static final Logger logger = LoggerFactory.getLogger(QRCodeUtil.class);
 
    // 二维码颜色
    private static final int BLACK = 0xFF000000;
    // 二维码颜色
    private static final int WHITE = 0xFFFFFFFF;
 
    private final BufferedImage image;
    private final int left;
    private final int top;
 
    public QRCodeUtil(BufferedImage image) {
        this(image, 0, 0, image.getWidth(), image.getHeight());
    }
 
    public QRCodeUtil(BufferedImage image, int left, int top, int width, int height) {
        super(width, height);
        int sourceWidth = image.getWidth();
        int sourceHeight = image.getHeight();
        if (left + width > sourceWidth || top + height > sourceHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        for (int y = top; y < top + height; y++) {
            for (int x = left; x < left + width; x++) {
                if ((image.getRGB(x, y) & 0xFF000000) == 0) {
                    image.setRGB(x, y, 0xFFFFFFFF); // = white
                }
            }
        }
        this.image = new BufferedImage(sourceWidth, sourceHeight, BufferedImage.TYPE_BYTE_GRAY);
        this.image.getGraphics().drawImage(image, 0, 0, null);
        this.left = left;
        this.top = top;
    }
 
    @Override
    public byte[] getRow(int y, byte[] row) {
        if (y < 0 || y >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + y);
        }
        int width = getWidth();
        if (row == null || row.length < width) {
            row = new byte[width];
        }
        image.getRaster().getDataElements(left, top + y, width, 1, row);
        return row;
    }
 
    @Override
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int area = width * height;
        byte[] matrix = new byte[area];
        image.getRaster().getDataElements(left, top, width, height, matrix);
        return matrix;
    }
 
    @Override
    public boolean isCropSupported() {
        return true;
    }
 
    @Override
    public LuminanceSource crop(int left, int top, int width, int height) {
        return new QRCodeUtil(image, this.left + left, this.top + top, width, height);
    }
 
    @Override
    public boolean isRotateSupported() {
        return true;
    }
 
    @Override
    public LuminanceSource rotateCounterClockwise() {
        int sourceWidth = image.getWidth();
        int sourceHeight = image.getHeight();
        AffineTransform transform = new AffineTransform(0.0, -1.0, 1.0, 0.0, 0.0, sourceWidth);
        BufferedImage rotatedImage = new BufferedImage(sourceHeight, sourceWidth, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = rotatedImage.createGraphics();
        g.drawImage(image, transform, null);
        g.dispose();
        int width = getWidth();
        return new QRCodeUtil(rotatedImage, top, sourceWidth - (left + width), getHeight(), width);
    }
 
    /**
     * @param matrix
     * @return
     */
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     * 二维码图片加入Logo
     * @param image 图片流
     * @param logoPic Logo图片物理位置
     * @throws Exception 异常上抛
     */
    public static void addLogo_QRCode(BufferedImage image, File logoPic) {
        Graphics2D g = image.createGraphics();  // 对象流传输
        BufferedImage logo = null; // 读取Logo图片
        try {
            logo = ImageIO.read(logoPic);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置logo的大小,本人设置为二维码图片的20%,由于过大会盖掉二维码
        int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ? (image.getWidth() * 2 / 10) : logo.getWidth(null);
        int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ? (image.getHeight() * 2 / 10) : logo.getWidth(null);

        // 计算图片放置位置
        // logo放在中心
        int x = (image.getWidth() - widthLogo) / 2;
        int y = (image.getHeight() - heightLogo) / 2;
        // 開始绘制图片
        g.drawImage(logo, x, y, widthLogo, heightLogo, null);
        g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
        g.setStroke(new BasicStroke(ZXingConfig.DEFAULT_BORDER));
        g.setColor(ZXingConfig.DEFAULT_BORDERCOLOR);
        g.drawRect(x, y, widthLogo, heightLogo);

        g.dispose();
        logo.flush();
        image.flush();
    }

    /**
     * 根据内容，生成指定宽高、指定格式的二维码图片
     * @param zxconfig
     * @throws Exception
     */
    private static String createQRCode(ZXingConfig zxconfig) throws Exception {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(
                zxconfig.getContent(),
                BarcodeFormat.QR_CODE,
                zxconfig.getWidth(),
                zxconfig.getHeight(),
                zxconfig.getHints()
        );
        BufferedImage image = toBufferedImage(bitMatrix);
        // 是否设置Logo图片
        if (zxconfig.isLogoFlg()) {
            addLogo_QRCode(image, new File(zxconfig.getLogoPath()));
        }

        File outputFile = new File(zxconfig.getPutPath());
        if (!ImageIO.write(image, zxconfig.getFormat(), outputFile)) {
            throw new IOException("Could not write an image of format " + zxconfig.getFormat() + " to " + outputFile);
        }
        return outputFile.getAbsolutePath();
    }

    public static HashMap<EncodeHintType, Object> getHintTypeMap(){
        HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 指定编码格式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 指定纠错等级
        hints.put(EncodeHintType.MARGIN, 2); // 白边大小，取值范围0~4
        return hints;
    }
 
    /**
     * 解析指定路径下的二维码图片
     * @param filePath 二维码图片路径
     * @return
     */
    public static String parseQRCode(String filePath) {
        String content = "";
        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new QRCodeUtil(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            MultiFormatReader formatReader = new MultiFormatReader();
            Result result = formatReader.decode(binaryBitmap, hints);
 
            logger.info("result 为：" + result.toString());
            logger.info("resultFormat 为：" + result.getBarcodeFormat());
            logger.info("resultText 为：" + result.getText());
            // 设置返回值
            content = result.getText();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return content;
    }
 
    public static void main(String[] args) {
        String context = "https://y.qq.com/portal/search.html#page=1&searchid=1&remoteplace=txt.yqq.top&t=song&w=%E7%9B%97%E5%B0%86%E8%A1%8C"; // 随机生成验证码

        ZXingConfig zxconfig = new ZXingConfig();
        zxconfig.setWidth(300);
        zxconfig.setHeight(300);
        zxconfig.setHints(getHintTypeMap());
        zxconfig.setContent(context);
        zxconfig.setFormat("png");
        zxconfig.setLogoFlg(true);
        zxconfig.setLogoPath("F:/maomi.jpg");
        zxconfig.setPutPath("F:/qrCode.png");
 
        try {
            // 生成二维码图片，并返回图片路径
            String pathName = createQRCode(zxconfig);
            System.out.println("生成二维码的图片路径： " + pathName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
