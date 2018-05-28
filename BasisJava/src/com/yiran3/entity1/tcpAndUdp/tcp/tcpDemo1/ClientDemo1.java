package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo1;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 *
 *    客户端发送信息，服务端接收信息
 *
 *    Socket客户端：
 *    	1、建立客户端；
 *    		public Socket(String host, int port)：
 *    	        	        指定服务器IP与端口
 *    	2、建立连接后，通过Socket中的IO流(Socket流)进行数据的传输；
 *    		public OutputStream getOutputStream()：
 *    	        	        输出数据
 *    		public InputStream getInputStream()：
 *    	        	        输入数据
 *    	3、关闭socket。
 * */

public class ClientDemo1 {
    public static void main(String[] args){
        try {
            // 1.建立客户端 指定服务器ip地址与端口号
            Socket socket = new Socket("192.168.13.22",8088);

            // 2.建立连接后，通过socket中的io流(socket流)进行数据传输
            OutputStream os = socket.getOutputStream();

            // 输出数据
            os.write(97);

            // 3.关闭套接字
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
