package tech_stuff.java_concepts.sockets.tcpip.multithreadedchat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ChatServer {
    public static final Map<String, String> clientQuestionsAnswers = Map.of(
            "hi", "hello!",
            "how are you?", "I'm fine, thank you.",
            "what's your name?", "I'm ChatServer.",
            "bye", "Goodbye!"
    );

    private ChatServer() {
    }
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("Chat server started on port 9999");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

//                Thread thread = new Thread(new handleChats(clientSocket));
//                thread.start();

                Thread.startVirtualThread(() -> {
                    try {
                        handleClientConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*private static void handleClientConnection(final Socket clientSocket) throws IOException {
        // We need to handle multiple clients concurrently
        final InputStream inputStream = clientSocket.getInputStream();
        final OutputStream outputStream = clientSocket.getOutputStream();
        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        String message = new String(buffer).trim();
        System.out.println("Received message: " + message);

        final Scanner scannerInput = new Scanner(System.in);
        System.out.print("Enter reply: ");
        String reply = scannerInput.nextLine();
        outputStream.write(reply.getBytes());
        clientSocket.close();
    }*/

    private static void handleClientConnection(final Socket clientSocket) throws IOException {
        final InputStream inputStream = clientSocket.getInputStream();
        final OutputStream outputStream = clientSocket.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            String message = new String(buffer, 0, bytesRead).trim();
            System.out.println("Received message: " + message);

            if (clientQuestionsAnswers.containsKey(message.toLowerCase())) {
                String reply = clientQuestionsAnswers.get(message.toLowerCase());
                outputStream.write(reply.getBytes());
            } else {
                String reply = "I don't understand your question.";
                outputStream.write(reply.getBytes());
            }
        }
        clientSocket.close();
    }


    static class handleChats implements Runnable {
        private final Socket clientSocket;

        public handleChats(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                handleClientConnection(clientSocket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
