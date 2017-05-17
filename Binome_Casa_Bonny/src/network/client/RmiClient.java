package network.client;

import network.server.RmiInterface;

import java.net.InetAddress;
import java.rmi.Naming;

public class RmiClient {
    public static void main(String[] args) {
        try {
            RmiInterface r = (RmiInterface)Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Miaou");
            System.out.println(r.add("nom", "description", "techno", "nomCréateur", "mailCréateur"));
            System.out.println(r.getEtus("2"));
            System.out.println(r.getIdeas());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
