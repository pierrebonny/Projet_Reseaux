package network.commands;

import network.server.JsonParser;

public class GetEtus implements Command {
    private int idIdea;

    public void parse(String request[]) {
        try {
            idIdea = Integer.parseInt(request[0].split("=")[1]);
        } catch (Exception e) {
            idIdea = -1;
        }
    }

    public String serialize() {
        JsonParser jp = new JsonParser();
        String answer = jp.serializeIdea(idIdea);
        return (idIdea == -1 || answer == null) ? "ERREUR:GET_ETUS - wrong request" : "OK\r\n\r\n" + answer;
    }
}
