package tech_stuff.java_concepts.sockets.udp.groupchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;
    private static Set<SocketAddress> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(PORT);
        byte[] buffer = new byte[BUFFER_SIZE];
        System.out.println("UDP Group Chat Server started on port " + PORT);

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Add client to the set
            clients.add(packet.getSocketAddress());

            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + msg + " from " + packet.getSocketAddress());

            // Broadcast to all clients
            for (SocketAddress client : clients) {
                DatagramPacket outPacket = new DatagramPacket(
                    msg.getBytes(), msg.length(), ((InetSocketAddress) client).getAddress(), ((InetSocketAddress) client).getPort()
                );
                socket.send(outPacket);
            }
        }
    }
}
