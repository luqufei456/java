package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo4;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 服务器端
 *
 *    文件上传，服务器端接收文件中的数据，向服务器端的一个文件中写出
 *
 *    接收文件内容，写出到某个文件
 * */

public class ServerDemo4 {
    public static void main(String[] args){
        try {
            // 1.建立服务器端
            ServerSocket serverSocket = new ServerSocket(8088);

            // 2.通过Socket服务获取Socket，再获取其中的IO流
            Socket socket = serverSocket.accept();

            // 3.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输；
            InputStream is = socket.getInputStream();

            //获取上传文件在服务器端的那个文件输出流
            FileOutputStream fos = new FileOutputStream("ASCII码表完整版copy.doc");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

            // 关闭文件流对象
            fos.close();

            //获取输出流，输出响应数据
            OutputStream out = socket.getOutputStream();
            String content ="收到了，请你滚";
            out.write(content.getBytes("utf-8"));

            //4、关闭socket。
            socket.close();
            serverSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
