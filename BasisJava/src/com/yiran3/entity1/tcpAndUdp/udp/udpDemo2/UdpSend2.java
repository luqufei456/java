package com.yiran3.entity1.tcpAndUdp.udp.udpDemo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP案例
 * 需求：
 *      发送端：不断的向接收端发送数据
 *      接收端：不断的接收从发送端发送过来的数据
 * */

public class UdpSend2 {
    public static void main(String[] args){
        try {
            // 1.建立发送端-- 也可以指定端口号
            DatagramSocket ds = new DatagramSocket();

            // 反复发送数据
            while (true){
                // 2.创建数据
                Scanner sc = new Scanner(System.in);
                System.out.print("请输入想要发送的内容：");
                String s = sc.nextLine();

                // 3.建立数据包 设置编码为utf-8 与接收端相同，防止中文乱码
                byte[] data = s.getBytes("utf-8");
                int length = data.length;
                InetAddress address = InetAddress.getByName("192.168.13.22");
                int port = 8088;
                DatagramPacket dp = new DatagramPacket(data, length, address, port);

                // 4.调用Socket发送方法
                ds.send(dp);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
