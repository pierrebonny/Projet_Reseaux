package network.commands;

public interface Command {
    void parse(String[] request);

    String serialize();
}
