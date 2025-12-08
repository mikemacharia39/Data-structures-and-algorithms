package tech_stuff.java_concepts.sockets.tcpip.singlethreadedsimplechat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    Socket clientSocket = null;
    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient();
        chatClient.chat();
    }

    private void chat() throws IOException {
        clientSocket = new Socket("127.0.0.1", 9999);
        System.out.println("Connected to chat server at: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

        // I want to keep "connection" open to send and receive multiple messages

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        String message = "Hello from Client!";
        outputStream.write(message.getBytes());
        System.out.println("Sent message: " + message);
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        String reply = new String(buffer).trim();
        System.out.println("Received reply: " + reply);
        clientSocket.close();


        // I want to keep "connection" open to send and receive multiple messages, let continue chatting
        Scanner scannerInput = new Scanner(System.in);
        while (true) {
            System.out.print("Enter message to send (or 'exit' to quit): ");
            String userMessage = scannerInput.nextLine();
            if (userMessage.equalsIgnoreCase("exit")) {
                sendMessage("Client is disconnected.");
                clientSocket.close();
                break;
            }
            sendMessage(userMessage);
            // Read reply
            receiveMessage();
        }
    }

    private void sendMessage(String message) throws IOException {
        if (clientSocket == null || clientSocket.isClosed()) {
            connectToServer();
        }

        System.out.println("Sending message: " + message);
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(message.getBytes());
    }

    private void receiveMessage() throws IOException {
        if (clientSocket == null || clientSocket.isClosed()) {
            connectToServer();
        }

        InputStream inputStream = clientSocket.getInputStream();
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        String message = new String(buffer).trim();
        System.out.println("Received message: " + message);
        clientSocket.close();
    }

    private void connectToServer() throws IOException {
        clientSocket = new Socket("127.0.0.1", 9999);
    }
}
