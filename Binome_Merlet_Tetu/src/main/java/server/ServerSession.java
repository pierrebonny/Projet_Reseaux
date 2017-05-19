package server;

import commands.*;
import server.model.IdeaManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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

    public ServerSession(Socket socket) throws IOException {
        this.out = new PrintWriter(socket.getOutputStream());;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        response = new StringBuilder();
        ideaManager = new IdeaManager();
    }

    @Override
    public void run() {
        try {
            while(true) {
                out.println("Entrez la commande de votre choix :");
                out.flush();
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
                        //commandOptional = Optional.of(new GetIdeas());
                        break;
                    case "GET_ETUS":
                        commandOptional = Optional.of(new GetEtus(params));
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
                out.print(response.toString());
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
