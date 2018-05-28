package com.yiran3.entity1.tcpAndUdp.udp.udpDemo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP案例
 * 需求：
 *      发送端：不断的向接收端发送数据
 *      接收端：不断的接收从发送端发送过来的数据
 * */

public class UdpReceive2 {
    public static void main(String[] args){
        try {
            // 1.建立接收端
            DatagramSocket ds = new DatagramSocket(8088);

            // 反复接收数据
            while (true){
                // 2.建立数据包，用于接收数据
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);

                // 3.调用Socket的接收方法
                ds.receive(dp);

                // 4.解析数据
                InetAddress sendAddress = dp.getAddress();
                int sendPort = dp.getPort();
                byte[] data = dp.getData();
                int length = dp.getLength();
                // 转换输出并输出
                String content = new String(data, 0, length, "utf-8");
                System.out.println("收到来自"+sendAddress+"的，端口号为" +sendPort+"的数据："+content);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
