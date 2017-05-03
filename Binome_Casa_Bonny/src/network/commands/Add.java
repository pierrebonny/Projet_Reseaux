package network.commands;

import java.util.HashMap;
import java.util.Map;

public class Add implements Command {
    private Map<String, String> datas;

    public Add() {
        datas = new HashMap<>();
    }

    public void parse(String request[]) {
        for (String data : request) {
            datas.put(data.split("=")[0], data.split("=")[1]);
        }
    }

    public String serialize() {
        return (datas.isEmpty()) ? "ERREUR:<doesn't work>" : "OK";
    }
}
