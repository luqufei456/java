package com.yiran.entity2.javaIO.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DomeServer extends Thread {
    private ServerSocket serverSocket;

    public int getPort(){
        return serverSocket.getLocalPort();
    }
    @Override
    public void run(){
        try {
            serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
