package com.yiran3.entity1.tcpAndUdp.udp.udpDemo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP的接收端
 *
 *    发送和接收均可以使用的Socket类：
 *     	DatagramSocket
 *
 *    数据打包的相关类：
 *     	DatagramPacket
 *
 *    使用UDP接收数据的步骤：
 *     	1、建立接收端；
 *     		public DatagramSocket(int port):	指定程序端口号，方便发送端寻找
 *     	2、建立数据包，用于接收数据；
 *     		public DatagramPacket(byte[] buf, int length)
 *     	3、调用Socket的接收方法；
 *     	4、解析数据dp；
 *     		public byte[] getData():	获取数据报包中的数据
 *     		public int getLength()：		获取数据报包中的数据长度
 *     		public InetAddress getAddress():	获取发送方的IP地址对象
 *     		public int getPort()：		获取发送方的端口号
 *     	5、关闭Socket。
 *
 *     ps：发送端与接收端是两个对立的运行程序。
 * */

public class UdpReceive1 {
    public static void main(String[] args){
        try {
            // 1.建立接收端
            DatagramSocket ds = new DatagramSocket(8088);

            // 2.建立数据包，用于接收数据
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            // 3.调用Socket的接收方法
            ds.receive(dp);

            // 4.解析数据
            // 获取发送方的地址对象
            InetAddress sendAddress = dp.getAddress();
            // 获取发送方的主机名
            String sendName = sendAddress.getHostName();
            // 获取发送放的IP地址
            String sendIP = sendAddress.getHostAddress();
            // 获取发送方的端口号
            int sendPort = dp.getPort();
            // 获取数据包中的数据和其长度
            byte[] data = dp.getData();
            int length = dp.getLength();

            // 将字节数组转为字符串
            String content = new String(data, 0, length,"utf-8");

            // 输出
            System.out.println("收到来自"+sendName+"的，端口号为"
                    +sendPort+"，IP为："+sendIP+"的数据："+content);

            // 5.关闭Socket
            ds.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
