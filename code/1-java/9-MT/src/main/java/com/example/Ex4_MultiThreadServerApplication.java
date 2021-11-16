package com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// TCP ( Transfer Control Protocol ) server
public class Ex4_MultiThreadServerApplication {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                System.out.println(Thread.currentThread().getName() + " waiting for incoming request..");
                Socket socket = serverSocket.accept();
                new Thread(handleClientConnection(socket)).start(); // thread-per-connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Runnable handleClientConnection(Socket socket) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + " handling new connection");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                String message = "";
                while (!"/quit".equals(message)) {
                    message = reader.readLine(); // read
                    System.out.println(Thread.currentThread().getName()+" -> "+message);
                    writer.write("~ " + message + "\n"); //write
                    writer.flush();
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

    }

}
