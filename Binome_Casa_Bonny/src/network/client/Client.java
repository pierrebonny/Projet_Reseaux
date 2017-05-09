package network.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int PORT_NUMBER = 15042;

    private void sendRequest(String request) {
        Socket myClient;
        try {
            myClient = new Socket(InetAddress.getLocalHost(), PORT_NUMBER);
            DataOutputStream output = new DataOutputStream(myClient.getOutputStream());
            output.write((request+"\n").getBytes());
            output.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String serialize(int idRequest) {
        switch (idRequest) {
            case 1:
                return "ADD name=nom miaou=nyan";
            case 2:
                return "GET_IDEAS";
            case 3:
                return "JOIN idIdée=1 mail=nyu@cat.org";
            case 4:
                return "GET_ETUS idIdée=2";
            case 5:
                return "SUB mail=nyu@cat.org";
            case 6:
                return "ACCEPT mailPersonneEnAttente=nyu@cat.org idIdée=2";
            case 7:
                return "DECLINE mailPersonneEnAttente=nyu@cat.org idIdée=2";
            case 8:
                return "FINALIZE idIdée=2";
            case 9:
                return "DELETE idIdée=2";
            default:
                return "QUIT";
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 1; i < 10; i++) {
            client.sendRequest(client.serialize(i));

        }
    }
}
