package com.qing.springboot1.httpText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServletSocket {
	public static void main(String args[]) {
		try {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(4700);	// 创建一个ServerSocket在端口4700监听客户请求
			} catch (Exception e) {
				System.out.println("can not listen to:" + e); // 出错，打印出错信息
			}

			Socket socket = null;
			try {
				socket = serverSocket.accept();  // 使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
			} catch (Exception e) {
				System.out.println("Error." + e); // 出错，打印出错信息
			}

			String line;
			String clientMsg = "";

			// 由Socket对象得到输入流，并构造相应的BufferedReader对象
			// 由Socket对象得到输出流，并构造PrintWriter对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());

			// 由系统标准输入设备构造BufferedReader对象
			BufferedReader sreader = new BufferedReader(new InputStreamReader(System.in));

			clientMsg = is.readLine();
			System.out.println("Client:" + clientMsg);	// 在标准输出上打印从客户端读入的字符串

			// 从标准输入读入一字符串
			line = sreader.readLine();

			// 如果该字符串为 "exit"，则停止循环
			while (true) {
				os.println(line);
				os.flush(); 	// 刷新输出流，使Client马上收到该字符串
				System.out.println("Server:" + line); // 在系统标准输出上打印读入的字符串

				clientMsg = is.readLine();
				System.out.println("Client:" + clientMsg); 	// 从Client读入一字符串，并打印到标准输出上
				if("exit".equals(clientMsg)){
					break;
				}
				// 继续循环
				line = sreader.readLine(); 	// 从系统标准输入读入一字符串
			}
			os.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
			serverSocket.close(); // 关闭ServerSocket

		} catch (Exception e) {
			System.out.println("Error:" + e);	// 出错，打印出错信息
		}

	}
}