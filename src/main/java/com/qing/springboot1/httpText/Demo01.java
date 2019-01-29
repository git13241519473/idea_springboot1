package com.qing.springboot1.httpText;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo01 {

    public static void main(String[] args) {
        try {
            /*URL url = new URL("http://www.baidu.com");
            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String data = br.readLine();//读取数据
            while(StringUtils.isNoneEmpty(data)){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            in.close();*/

            InetAddress inet1 = InetAddress.getByName("www.163.com");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getLocalHost();
            System.out.println(inet2.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
