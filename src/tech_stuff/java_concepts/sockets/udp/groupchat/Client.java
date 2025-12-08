package tech_stuff.java_concepts.sockets.udp.groupchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        // Thread to listen for incoming messages
        new Thread(() -> {
            byte[] buffer = new byte[BUFFER_SIZE];
            while (true) {
                try {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String msg = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Received: " + msg);
                } catch (IOException e) {
                    break;
                }
            }
        }).start();

        System.out.println("Enter messages to send. Type 'exit' to quit.");
        while (true) {
            String msg = userInput.readLine();
            if (msg == null || msg.equalsIgnoreCase("exit")) {
                socket.close();
                break;
            }
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, SERVER_PORT);
            socket.send(packet);
        }
    }
}
