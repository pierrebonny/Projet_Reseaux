package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author : thomas
 * @version : 09/05/17
 */
public class ServerSession implements Runnable {

    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public ServerSession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
