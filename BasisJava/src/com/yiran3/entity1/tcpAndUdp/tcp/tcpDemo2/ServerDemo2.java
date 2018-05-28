package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 *
 *    服务器响应数据
 *
 *    服务器端只需要按照顺序，在完成输入数据后，再获取输出流，输出数据即可
 * */

public class ServerDemo2 {
    public static void main(String[] args){
        try {
            // 1.建立服务器端
            ServerSocket serverSocket = new ServerSocket(8088);

            // 2.获取Socket，再获取其中的io流
            Socket socket = serverSocket.accept();

            // 3.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输；
            InputStream is = socket.getInputStream();
            int read = is.read();
            System.out.println(read);
            System.out.println((char) read);

            // 获取输出流，输出响应数据
            OutputStream os = socket.getOutputStream();
            os.write(97);

            // 4.关闭socket
            socket.close();
            serverSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
