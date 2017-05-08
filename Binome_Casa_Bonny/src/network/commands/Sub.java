package network.commands;

public class Sub implements Command {
    private String mail;

    public void parse(String request[]) {
        try {
            mail = request[0].split("=")[1];
        } catch (Exception e) {
            mail = null;
        }
    }

    public String serialize() {
        return (mail == null) ? "ERREUR:Sub - wrong request" : "OK";
    }

    public String getMail() {
        return mail;
    }
}
