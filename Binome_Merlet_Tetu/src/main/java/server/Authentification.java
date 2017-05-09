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
public class Authentification implements Runnable{

    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private boolean authentified = false;
    private String mailLogin = null;

    public Authentification(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (!authentified){
                out.println("Entrer votre adresse e-mail pour vous connecter : ");
                out.flush();
                mailLogin = in.readLine();

                out.println("Connecté !");
                out.flush();

                authentified = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
