package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 *
 * 	  客户端发送信息，服务端接收信息
 *
 *    ServerSocket服务器端：
 *    	1、建立服务器端；
 *    		public ServerSocket(int port)：	指定服务器端端口，方便客户端访问
 *    	2、由于是服务器端，则需要添加一步操作：通过Socket服务获取Socket，再获取其中的IO流
 *    		public Socket accept()：			接收一个socket对象
 *    	3、建立连接后，通过Socket中的IO流(Socket流)进行数据的传输；
 *    		public OutputStream getOutputStream()：	输出数据
 *    		public InputStream getInputStream()：	输入数据
 *    	4、关闭socket。
 * */

public class ServerDemo1 {
    public static void main(String[] args){
        try {
            // 1.建立服务器端
            ServerSocket serverSocket = new ServerSocket(8088);

            // 2.服务器要先通过Socket服务获取Socket，再获取其中的io流
            // 会一直这里循环，监听是否有客户端连接，有连接后才会往下运行
            Socket socket = serverSocket.accept();

            // 3.建立连接后，通过Socket中的IO流(Socket流)进行数据传输
            InputStream is = socket.getInputStream();

            int read = is.read();
            System.out.println(read);
            System.out.println((char)read);

            // 关闭socket
            socket.close();
            serverSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
