package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Client {
    public static void main(String[] argv) {
        Socket socket;

        try {
            socket = new Socket(InetAddress.getLocalHost(),15042);
            System.out.println("Demande de connexion");

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            writer.println("Bonjour je suis le client !");
            writer.flush();

            String message_distant = reader.readLine();
            System.out.println("Le serveur dit : " + message_distant);

            writer.close();
            reader.close();
            socket.close();

        }catch (UnknownHostException e) {

            e.printStackTrace();

        }catch (IOException e) {

            e.printStackTrace();

        }

    }
}
