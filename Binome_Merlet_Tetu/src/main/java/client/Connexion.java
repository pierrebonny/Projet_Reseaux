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
public class Connexion implements Runnable {

    private Socket serverSocket = null;
    private Thread session = null;

    private String mailLogin = null;

    private PrintWriter out = null;
    private BufferedReader in = null;

    private Scanner scanner = null;

    private boolean connected = false;

    public Connexion(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(serverSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            scanner = new Scanner(System.in);

            while(!connected){
                System.out.println(in.readLine());
                mailLogin = scanner.nextLine();
                out.println(mailLogin);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
