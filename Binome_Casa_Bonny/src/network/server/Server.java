package network.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT_NUMBER = 15042;

    private ServerSocket server;
    private Socket clientSocket;

    public Server() {
        clientSocket = null;
    }

    public void launchServer() {
        try {
            server = new ServerSocket(PORT_NUMBER);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public void listen() {
        Parser parser = new Parser();
        BufferedReader input;

        while (true) {
            try {
                clientSocket = server.accept();
            }
            catch (IOException e) {
                System.err.println(e);
            }

            try {
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            catch (IOException e) {
                System.out.println(e);
                break;
            }
            answer(parser.parse(input));
        }
    }

    private void answer(String response) {
        try {
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            output.write(response.getBytes());
            output.flush();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.launchServer();
        server.listen();
    }
}
