package com.yiran3.entity1.tcpAndUdp;

import java.net.InetAddress;

/**
 * IP概述
 *
 *    IP地址是一台电脑在网络当中最常用的唯一标识，
 *    也可以使用主机名(计算机名)在网络中找到电脑主机，但是主机名有可能重复，
 *    会带来许多不安全的因素，所以一般弃用主机名，
 *    主要使用IP地址
 *
 *    由四个网段组成：
 *    其本质为：
 *    	4个字节的二进制数
 *    二进制数	11111111	10101010	01010101	11110000
 *    十进制	      数字1		  数字2		  数字3		  数字4
 *
 *    由于每段数字均由一个字节翻译成十进制数，所有最大为255
 *
 *    Java中的InetAddress代表地址，主要代表IP地址
 *
 *    获取地址对象：
 *    	public static InetAddress getLocalHost() throws UnknownHostException：
 *    		获取本地主机
 *    	public static InetAddress getByName(String host) throws UnknownHostException：
 *    		依据主机名(或者是IP地址字符串)获取主机
 *
 *    通过地址对象获取IP字符串或者主机名称字符串:
 *    	public String getHostName():	获取主机名称
 *    	public String getHostAddress():	获取主机字符串形式的IP
 * */

public class IpDemo1 {
    public static void main(String[] args){
        try {
            // 获取本机ip地址对象 直接输出为主机名称/ip地址
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("主机名称/ip地址："+localhost);
            // 获取ip字符串或主机名称字符串
            // 获取主机名称
            String hostName = localhost.getHostName();
            System.out.println("本机的主机名称为："+hostName);
            // 获取主机字符串形式的ip  其实就是ip地址
            String hostAddress = localhost.getHostAddress();
            System.out.println("本机的ip字符串为："+hostAddress);

            //获取其他主机IP 地址对象
            InetAddress byName = InetAddress.getByName("DESKTOP-38PFPJM");
            System.out.println("其他主机的地址对象为："+byName);

            InetAddress byName2 = InetAddress.getByName("192.168.13.22");

            System.out.println("其他主机的地址对象为："+byName2);
            // 由于该主机没有主机名 所以会一直找，程序无法停止
            // String thisName = byName2.getHostName();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
