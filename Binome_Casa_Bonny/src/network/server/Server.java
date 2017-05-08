package network.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT_NUMBER = 15042;

    private ServerSocket server;
    private Socket clientSocket;

    private Server() {
        clientSocket = null;
    }

    private void launchServer() {
        try {
            server = new ServerSocket(PORT_NUMBER);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        Parser parser = new Parser();
        BufferedReader input;

        while (parser.hasToQuit()) {
            try {
                clientSocket = server.accept();
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            answer(parser.parse(input));
        }

        try {
            clientSocket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void answer(String response) {
        try {
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            output.write(response.getBytes());
            output.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.launchServer();
        server.listen();
    }
}
