package server;

import commands.Add;
import commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : thomas
 * @version : 09/05/17
 */
public class ServerSession implements Runnable {

    private PrintWriter out = null;
    private BufferedReader in = null;

    private String request= null;
    private String requestType = null;
    private String[] params = null;

    private StringBuilder response = null;

    public ServerSession(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
        response = new StringBuilder();
    }

    @Override
    public void run() {
        out.println("Entrez la commande de votre choix :");
        out.flush();

        try {
            while(true) {
                Command command;
                request = in.readLine();
                requestType = request.split(" ")[0];
                fillParams();
                switch (requestType) {
                    case "ADD":
                        command = new Add(params);
                        command.interpret();
                        response.append(command.result());
                        break;
                    default:
                        response.append("ERREUR: La requête " + requestType + " n'existe pas.");
                        break;
                }
                out.println(response.toString());
                out.flush();
                response.setLength(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void fillParams() throws IOException {
       params = request.split(" ");
    }
}
