package com.yiran.entity2.javaIO.nio;

import java.io.PrintWriter;
import java.net.Socket;

// 简化实现，不做读取，直接发送字符串
public class RequestHandler extends Thread {
    private Socket socket;
    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 这样写，pw会在结束后自动close()
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.println("hello world");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
