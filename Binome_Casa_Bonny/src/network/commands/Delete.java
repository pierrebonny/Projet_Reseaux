package network.commands;

public class Delete implements Command {
    private String idIdea;

    public void parse(String request[]) {
        try {
            idIdea = request[0].split("=")[1];
        } catch (Exception e) {
            idIdea = null;
        }
    }

    public String serialize() {
        return (idIdea == null) ? "ERREUR:Delete - wrong request" : "OK";
    }

    public String getIdIdea() {
        return idIdea;
    }
}
