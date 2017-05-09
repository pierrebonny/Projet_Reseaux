package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

public class ServerMain {
    private static final int PORT_NUMBER = 15042;

    public static void main(String[] argv) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            while (true) {
                ServerThread serverThread = new ServerThread(Optional.of(serverSocket.accept()));
                serverThread.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
