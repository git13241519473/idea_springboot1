package com.qing.springboot1.utils.zxing;

import java.awt.*;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;

/**
 * 二维码配置信息
 */
public class ZXingConfig {
    private String content; // 二维码编码内容
    private int width = 300;    // 生成图片宽度
    private int height = 300;   //  生成图片高度
    private Map<EncodeHintType, Object> hints;   // 设置參数
    private String putPath; // 图片输出路径
    private String format; //图片格式 png jpg jpeg

    private boolean logoFlg = false;    // 是否加入Log图片
    private String logoPath;    // Logo图片路径
    public static final Color DEFAULT_BORDERCOLOR = Color.WHITE;    //默认边框颜色
    public static final int DEFAULT_BORDER = 2; // logo默认边框宽度

    // getter 、 setter 方法
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<EncodeHintType, Object> getHints() {
        return hints;
    }

    public void setHints(Map<EncodeHintType, Object> hints) {
        this.hints = hints;
    }

    public String getPutPath() {
        return putPath;
    }

    public void setPutPath(String putPath) {
        this.putPath = putPath;
    }

    public boolean isLogoFlg() {
        return logoFlg;
    }

    public void setLogoFlg(boolean logoFlg) {
        this.logoFlg = logoFlg;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}