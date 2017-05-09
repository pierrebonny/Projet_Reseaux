package network.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int PORT_NUMBER = 15042;
    private Socket myClient;

    private void sendRequest(String request) {
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

    private void listen() {
        BufferedReader input;
        String answer;
        try {
            input = new BufferedReader(new InputStreamReader(new DataInputStream(myClient.getInputStream())));
            String line;
            StringBuilder builder = new StringBuilder();
            try {
                while ((line = input.readLine()) != null) {
                    builder.append(line);
                }
                System.out.println(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client;
        for (int i = 1; i < 10; i++) {
            client = new Client();
            client.sendRequest(client.serialize(i));
            client.listen();
        }
    }
}
