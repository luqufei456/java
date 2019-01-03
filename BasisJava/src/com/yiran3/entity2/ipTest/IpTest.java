package com.yiran3.entity2.ipTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class IpTest {
    public static void main(String[] args){
        boolean isReachable = false;
        Socket socket = null;
        InetAddress inetAddress = null;
        try {
            socket = new Socket();
            inetAddress = InetAddress.getByName("www.baidu.com");
            // Creates a socket address from an IP address and a port number
            InetSocketAddress endpointSocketAddr = new InetSocketAddress(inetAddress, 80);
            socket.connect(endpointSocketAddr, 1000);
            System.out.println("SUCCESS - remote: " + inetAddress.getHostAddress() + " port " + 80);
            isReachable = true;
        } catch (IOException e) {
            System.out.println("FAILRE - remote: " + inetAddress.getHostAddress() + " port " + 80);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error occurred while closing socket..");
                }
            }
        }
        System.out.println(isReachable);
    }
}
