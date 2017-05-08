package network.commands;

import java.util.HashMap;
import java.util.Map;

public class Decline implements Command {
    private Map<String, String> content;

    public Decline() {
        content = new HashMap<>();
    }

    public void parse(String request[]) {
        for (String data : request) {
            try {
                content.put(data.split("=")[0], data.split("=")[1]);
            } catch (Exception e) {
                content.clear();
                break;
            }
        }
    }

    public String serialize() {
        return (content.isEmpty()) ? "ERREUR:Decline - wrong request" : "OK";
    }
}
