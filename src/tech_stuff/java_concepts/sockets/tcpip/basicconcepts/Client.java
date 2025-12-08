package tech_stuff.java_concepts.sockets.tcpip.basicconcepts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        System.out.println("Starting Client...");
        try {
            Socket clientSocket = new Socket("127.0.0.1", 9999);

            System.out.println("Connected to server: " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            outputStream.write("Hello World From Client".getBytes());

            byte[] bufferResponse = new byte[1024]; // 1024 bytes buffer
            inputStream.read(bufferResponse);

            System.out.println("Response from server: " + new String(bufferResponse).trim());

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
