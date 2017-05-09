package network.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int PORT_NUMBER = 15042;

    private void sendRequestQuit(){
        Socket myClient;
        try {
            myClient = new Socket(InetAddress.getLocalHost(), PORT_NUMBER);
            DataOutputStream output = new DataOutputStream(myClient.getOutputStream());
            output.write("QUIT\n".getBytes());
            output.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest() {
        Socket myClient;
        try {
            myClient = new Socket(InetAddress.getLocalHost(), PORT_NUMBER);
            DataOutputStream output = new DataOutputStream(myClient.getOutputStream());
            output.write(serialize().getBytes());
            output.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String serialize() {
        return "GET_IDEAS\n";
        //return "ADD name=nom miaou=nyan\n";
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendRequest();
        client.sendRequestQuit();
    }
}
