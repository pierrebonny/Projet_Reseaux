package network.server;

import network.commands.*;

import java.io.BufferedReader;
import java.io.IOException;

class Parser {
    private boolean quit;

    Parser() {
        quit = false;
    }

    String parse(BufferedReader buffer) {
        String request = null;
        try {
            request = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String requestSplited[] = request.split(" ");

        int length = requestSplited.length;
        String params[] = new String[length - 1];
        System.arraycopy(requestSplited, 1, params, 0, length-1);

        Command command;
        switch (requestSplited[0]) {
            case "ADD":
                command = new Add();
                break;
            case "GET_IDEAS":
                command = new GetIdeas();
                break;
            case "JOIN":
                command = new Join();
                break;
            case "GET_ETUS":
                command = new GetEtus();
                break;
            case "SUB":
                command = new Sub();
                break;
            case "ACCEPT":
                command = new Accept();
                break;
            case "DECLINE":
                command = new Decline();
                break;
            case "FINALIZE":
                command = new Finalize();
                break;
            case "DELETE":
                command = new Delete();
                break;
            case "QUIT":
                command = new Quit();
                quit = true;
                break;
            default:
                return "ERREUR:Commande non reconnue";
        }
        command.parse(params);

        return command.serialize();
    }

    boolean hasToQuit() {
        return quit;
    }
}
