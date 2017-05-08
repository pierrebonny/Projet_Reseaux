package network.commands;

import network.server.JsonParser;

public class GetIdeas implements Command {

    public void parse(String[] request) {
        //There isn't argument to parse.
    }

    public String serialize() {
        JsonParser jp = new JsonParser();
        return "OK\r\n\r\n" + jp.serializeIdeas();
    }
}
