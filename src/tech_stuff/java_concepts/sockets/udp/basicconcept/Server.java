package tech_stuff.java_concepts.sockets.udp.basicconcept;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8989);
        System.out.println("UDP Server is running on port 8989");

        DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], 1024);

        server.receive(receivedPacket);
        String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
        System.out.println("Received message: " + receivedMessage
                + " from " + receivedPacket.getAddress()
                + ":" + receivedPacket.getPort());
        server.close();
    }
}
