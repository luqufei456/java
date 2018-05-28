package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器端
 *
 *    客户端发送一个字符串i love java信息，接收服务器端返回一个字母o的响应 才怪
 * */

public class ServerDemo3 {
    public static void main(String[] args){
        try {
            // 1.建立服务器端
            ServerSocket serverSocket = new ServerSocket(8088);

            // 2.通过Socket服务获取Socket，再获取其中的IO流
            Socket socket = serverSocket.accept();

            int i = 10;
            // 循环接收数据
            while (i >0) {
                // 3.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输
                InputStream is = socket.getInputStream();
                byte[] buf = new byte[1024];
                int len;
                while ((len = is.read(buf)) != -1) {
                    System.out.print(new String(buf, 0, len, "utf-8"));
                }
                i--;
            }

            // 获取输出流，输出响应数据
            OutputStream os = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入你想回复的话：");
            String s = sc.nextLine();
            byte[] bytes = s.getBytes("utf-8");
            os.write(bytes);

            // 4.关闭套接字
            socket.close();
            serverSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
