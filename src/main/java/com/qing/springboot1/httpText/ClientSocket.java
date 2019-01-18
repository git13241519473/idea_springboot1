package com.qing.springboot1.httpText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {

    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1",4700);   //向本机的4700端口发出客户请求

            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            //由Socket对 象得到输出流，并构造PrintWriter对象
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());

            //由系统标准输入设备构造BufferedReader对象
            BufferedReader sreader = new BufferedReader(new InputStreamReader(System.in));

            String readline = sreader.readLine(); //从系统标准输入读入一字符串

            //若从标准输入读入的字符串为 "bye"则停止循环
            while(true){
                os.println(readline);   //将从系统标准输入读入的字符串输出到Server
                os.flush();     //刷新输出流，使Server马上收到该字符串

                System.out.println("Client:"+readline); //在系统标准输出上打印读入的字符串

                if("exit".equals(readline)){
                    break;
                }
                System.out.println("Server:"+is.readLine());    //从Server读入一字符串，并打印到标准输出上
                //继续循环
                readline = sreader.readLine(); //从系统标准输入读入一字符串
            }
            os.close(); //关闭Socket输出流
            is.close(); //关闭Socket输入流
            socket.close(); //关闭Socket

        } catch(Exception e) {
            System.out.println("Error"+e); //出错，则打印出错信息
        }

    }
}
