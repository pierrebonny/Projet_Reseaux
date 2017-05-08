package network.server;

import network.commands.*;

import java.io.BufferedReader;
import java.io.IOException;

class Parser {
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
        Command command = null;
        switch (requestSplited[0]) {
            case "ADD":
                command = new Add();
                break;
            case "GET_IDEAS":
                command = new GetIdeas();
            default:
                break;
        }

        command.parse(params);
        return command.serialize();
    }
}
