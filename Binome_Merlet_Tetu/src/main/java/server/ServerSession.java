package server;

import commands.Add;
import commands.Command;
import commands.Join;
import model.IdeaManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * @author : thomas
 * @version : 09/05/17
 */
public class ServerSession implements Runnable {

    private PrintWriter out = null;
    private BufferedReader in = null;

    private IdeaManager ideaManager;

    private String request= null;
    private String requestType = null;
    private String[] params = null;

    private StringBuilder response = null;

    public ServerSession(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
        response = new StringBuilder();
        ideaManager = new IdeaManager();
    }

    @Override
    public void run() {
        out.println("Entrez la commande de votre choix :");
        out.flush();

        try {
            while(true) {
                Optional<Command> commandOptional = Optional.empty();
                request = in.readLine();
                requestType = request.split(" ")[0];
                fillParams();
                switch (requestType) {
                    case "ADD":
                        commandOptional = Optional.of(new Add(params));
                        break;
                    case "JOIN":
                        commandOptional = Optional.of(new Join(params));
                        break;
                    case "GET_IDEAS":
                        response.append(ideaManager.toString());
                        break;
                    default:
                        commandOptional = Optional.empty();
                        response.append("ERREUR: La requête " + requestType + " n'existe pas.");
                        break;
                }
                if(commandOptional.isPresent()){
                    commandOptional.get().interpret(ideaManager);
                    response.append(commandOptional.get().result());
                    System.out.println(commandOptional.get().resultServer());
                }
                out.println(response.toString());
                out.flush();
                response.setLength(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fillParams() throws IOException {
       params = request.split(" ");
    }
}
