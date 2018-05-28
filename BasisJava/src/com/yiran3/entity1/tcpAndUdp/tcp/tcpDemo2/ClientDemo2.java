package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 *
 *    服务器响应数据
 *
 *    客户端只需要按照顺序，在输出数据后，再获取输入流，输入数据即可
 * */

public class ClientDemo2 {
    public static void main(String[] args){
        try {
            // 1.建立客户端
            Socket socket = new Socket("192.168.13.22",8088);

            // 2.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输
            OutputStream os = socket.getOutputStream();

            // 输出数据
            os.write(97);

            // 获取输入流，输入相应数据到内存中
            InputStream is = socket.getInputStream();
            int read = is.read();

            System.out.println(read);
            System.out.println((char)read);

            // 3.关闭socket套接字
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
