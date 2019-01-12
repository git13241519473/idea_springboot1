package com.qing.springboot1.utils.pinyin4j;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

/**
 * 汉字转为拼音工具类
 */
public class Pinyin4jUtil {

    public static void main(String[] args) {
        System.out.println(parseChinese2SinglePinyin("了结"));
    }

    /**
     * 将汉语转为拼音
     * @param chines 汉字
     * @return 拼音
     */
    public static String parseChinese2SinglePinyin(String chines) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (StringUtils.contains(chines, "/")) {// 如果中文中包含/，那么进行替换.
            chines = StringUtils.replace(chines, "/", "");
        }
        char[] ch = chines.trim().toCharArray();
        StringBuffer buffer = new StringBuffer("");
        try {
            for (int i = 0; i < ch.length; i++) {
                // unicode，bytes应该也可以.
                if (Character.toString(ch[i]).matches("[\u4e00-\u9fa5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(ch[i], format);
                    buffer.append(temp[0]);
                    buffer.append("");
                } else {
                    buffer.append(Character.toString(ch[i]));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        String pinyin = buffer.toString();
        if (StringUtils.contains(pinyin, ":")) {
            pinyin = StringUtils.replace(pinyin, ":", "");
        }
        return pinyin;
    }

    /**
     * 将汉语的每个首字符转为拼音  你真好 -->  NZH
     * @param chinese 汉字
     * @return 拼音
     */
    public static String getFirstLetter(String chinese){
        return getFirstLetter(chinese, HanyuPinyinCaseType.UPPERCASE);
    }
    public static String getFirstLetter(String chinese, HanyuPinyinCaseType caseType){
        char[] charray = chinese.toString().toCharArray();
        StringBuffer sbuffer = new StringBuffer();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(caseType);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   //不带声调
        try {
            for(int i = 0; i < charray.length; i++){
                if (String.valueOf(charray[i]).matches("[\u4e00-\u9fa5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(charray[i], format);
                    sbuffer.append(temp[0].substring(0, 1));
                } else {
                    sbuffer.append(Character.toString(charray[i]));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return sbuffer.toString();
    }

    /**
     * 将汉语的每个首字符转为拼音  你真好 -->  NZH
     * @param chinese 汉字
     * @return 拼音
     */
    public static String getFirstLetterUpper(String chinese){
        HanyuPinyinCaseType caseType = HanyuPinyinCaseType.UPPERCASE;
        return getFirstLetter(chinese, caseType);
    }

    /**
     * 将汉语的每个首字符转为拼音  你真好 -->  nzh
     * @param chinese 汉字
     * @return 拼音
     */
    public static String getFirstLetterLower(String chinese){
        HanyuPinyinCaseType caseType = HanyuPinyinCaseType.LOWERCASE;
        return getFirstLetter(chinese, caseType);
    }

}
