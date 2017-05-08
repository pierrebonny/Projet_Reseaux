package network.commands;

public class Quit implements Command {
    public void parse(String request[]) {
        //There isn't argument to parse.
    }

    public String serialize() {
        return "OK";
    }
}
