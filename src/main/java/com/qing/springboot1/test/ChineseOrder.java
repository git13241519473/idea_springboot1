package com.qing.springboot1.test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class ChineseOrder {

    public static void main(String[] args) {
        String[] names = new String[]{"张三", "李四", "王五", "赵六", "柴七", "崔八", "老九"};

        getSortOfChinese(names);

        for(int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

    }

    public static String[] getSortOfChinese(String[] a) {
        // Collator 类是用来执行区分语言环境这里使用CHINA
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);

        // JDKz自带对数组进行排序。
        Arrays.sort(a, cmp);
        return a;
    }

}
