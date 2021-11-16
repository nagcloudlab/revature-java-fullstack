package com.example;

import java.io.*;
import java.net.*;

// TCP ( Transfer Control Protocol ) server
public class Ex3_SingleThreadServerApplication {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                System.out.println("server waiting for incoming request..");
                Socket socket = serverSocket.accept();
                System.out.println("server accepted client connection,server handling request");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                String message = "";
                while (!"/quit".equals(message)) {
                    message = reader.readLine(); // read
                    System.out.println(message);
                    writer.write("~ " + message + "\n"); //write
                    writer.flush();
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
