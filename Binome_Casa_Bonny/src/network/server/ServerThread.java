package network.server;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class ServerThread implements Runnable {
    private Socket clientSocket;
    private Optional<Socket> socket;

    ServerThread(Optional<Socket> socket){
        this.socket = socket;
    }

    private void listen() {
        Parser parser = new Parser();
        BufferedReader input;
        while (!parser.hasToQuit()) {
            try {
                clientSocket = socket.get();
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            answer(parser.parse(input));
            break;
        }

        try {
            clientSocket.close();
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

    @Override
    public void run() {
        if (socket.isPresent()) {
            listen();
        }
    }
}
