package com.qing.springboot1.baseNumType;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList(10);
        list.add("当头炮");
        list.add("过宫马");
        list.add("五七炮");
        list.add("卧槽马");
        list.add("过河卒");
        list.add("占肋车");
        list.add("屏风马");
        list.add("后手");
        System.out.println(list.toString());
    }
}
