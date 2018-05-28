package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.FileInputStream;

/**
 * 客户端
 *
 *    文件上传，客户端发送的数据是一个文件当中的数据
 *
 *    读取文件内容，发送给服务器端
 *
 *    可以优化成传输地址或文件名到服务器端，然后巴拉巴拉，反正蛮容易的
 * */

public class ClientDemo4 {
    public static void main(String[] args){
        try {
            // 1.建立客户端
            Socket socket = new Socket("192.168.13.22",8088);

            // 2.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输；
            OutputStream os = socket.getOutputStream();

            // 获取资源文件输入流对象
            FileInputStream fis = new FileInputStream("ASCII码表完整版.doc");

            // 读取文件内容
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                // 输出数据到服务器
                os.write(bytes, 0, len);
            }

            // 关闭资源文件输入流
            fis.close();

            // 告知服务器，不再发送数据了
            socket.shutdownOutput();

            // 获取输入流，得到响应数据
            InputStream is = socket.getInputStream();
            while ((len = fis.read(bytes)) != -1){
                System.out.println(new String(bytes, 0, len, "utf-8"));
            }

            // 3.关闭
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
