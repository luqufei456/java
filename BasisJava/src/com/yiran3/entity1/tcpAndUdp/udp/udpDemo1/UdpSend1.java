package com.yiran3.entity1.tcpAndUdp.udp.udpDemo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP的发送端示例
 *
 *    发送和接收均可以使用的Socket类：
 *     	DatagramSocket
 *
 *    数据打包的相关类：
 *     	DatagramPacket
 *
 *    使用UDP发送数据的步骤：
 *     	1、建立发送端，空参构造；
 *     	public DatagramSocket() throws SocketException {
 *     	    this(new InetSocketAddress(0));
 *     	}
 *     	2、创建数据；
 *     	3、建立数据包；
 *     		public DatagramPacket(byte[] buf,	        数据打包成的字节数组
                                  int length,			数据的长度
                                  InetAddress address,	目标程序IP地址
                                  int port)				目标程序端口
 *     	4、调用Socket的发送；
 *     		public void send(DatagramPacket p)	发送数据报包
 *     	5、关闭Socket。
 *
 *     ps：发送端与接收端是两个对立的运行程序。
 * */

public class UdpSend1 {
    public static void main(String[] args){
        try {
            // 1.建立发送端
            DatagramSocket ds = new DatagramSocket();

            // 2.创建数据
            String s = "hello,my name is yiran";

            // 3.建立数据包--将数据组转为字节数组
            byte[] data = s.getBytes();
            int len = data.length;
            // 根据ip地址获取要发送到的主机对象
            InetAddress address = InetAddress.getByName("192.168.13.22");
            // 目标端口号
            int port = 8088;
            DatagramPacket dp = new DatagramPacket(data, len, address, port);

            // 4.调用Socket的发送方法
            ds.send(dp);

            // 5.关闭套接字
            ds.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
