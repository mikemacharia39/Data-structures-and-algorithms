package tech_stuff.java_concepts.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Starting Server...");
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            InputStream inputStream = clientSocket.getInputStream();

            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            inputStream.read(buffer);

            System.out.println("Received from client: " + new String(buffer).trim());

            outputStream.write("Hello World From Server!".getBytes());

            clientSocket.close();

            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
