package com.yiran3.entity1.tcpAndUdp.tcp.tcpDemo3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 *
 *    客户端发送一个字符串i love java信息，接收服务器端返回一个字母o的响应
 *
 *    public void shutdownOutput():	禁止输出流，告知对方将不再输出数据
 * */

public class ClientDemo3 {
    public static void main(String[] args){
        try {
            // 1.建立客户端
            Socket socket = new Socket("192.168.13.22",8088);

            // 2.建立连接后，通过Socket中的IO流(Socket流)进行数据的传输
            OutputStream os = socket.getOutputStream();

            Scanner sc = new Scanner(System.in);
            int i = 10;
            // 循环发送数据
            while (i >0){
                // 3.输出数据
                System.out.print("请输入想要发送的内容：");
                String s = sc.nextLine();
                byte[] buf = s.getBytes("utf-8");
                os.write(buf);
                i--;
            }
            // 告知服务器，不再发送数据了
            socket.shutdownOutput();

            // 获取输入流，得到响应数据
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, len, "utf-8"));
            }

            // 3.关闭套接字
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
