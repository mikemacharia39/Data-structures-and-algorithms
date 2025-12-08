package tech_stuff.java_concepts.sockets.singlethreadedsimplechat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Chat server started on port 9999");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client connected: " + clientSocket.getInetAddress());

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            inputStream.read(buffer);

            String message = new String(buffer).trim();
            System.out.println("Received message: " + message);

            Scanner scannerInput = new Scanner(System.in);

            System.out.print("Enter reply: ");
            String reply = scannerInput.nextLine();
            outputStream.write(reply.getBytes());

            clientSocket.close();
        }
    }
}
