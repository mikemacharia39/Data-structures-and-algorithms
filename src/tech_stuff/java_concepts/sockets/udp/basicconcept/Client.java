package tech_stuff.java_concepts.sockets.udp.basicconcept;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();

        String message = "Hello from UDP Client!";
        byte[] messageBytes = message.getBytes();
        DatagramPacket packet = new DatagramPacket(
                messageBytes,
                messageBytes.length,
                java.net.InetAddress.getLocalHost(), 8989);

        clientSocket.send(packet);
        System.out.println("Sent message: " + message);
        clientSocket.close();
    }
}
