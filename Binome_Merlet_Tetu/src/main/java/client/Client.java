package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Client {
    public static void main(String[] argv) {
        Socket socket;

        try {
            socket = new Socket(InetAddress.getLocalHost(),15042);
            System.out.println("Connexion établie !\nAuthentification : ");

            Thread t = new Thread(new Connexion(socket));
            t.start();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
