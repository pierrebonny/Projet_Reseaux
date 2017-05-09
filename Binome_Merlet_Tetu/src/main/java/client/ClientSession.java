package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : thomas
 * @version : 09/05/17
 */
public class ClientSession implements Runnable {

    private Socket socket;

    private PrintWriter out = null;
    private BufferedReader in = null;

    private Scanner scanner = null;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            scanner = new Scanner(System.in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
