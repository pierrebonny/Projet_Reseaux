package network.server;

import java.net.InetAddress;
import java.rmi.Naming;

public class RmiServerThread {
    public static void main(String[] args) {
        try {
            RmiInterfaceImpl informationImpl = new RmiInterfaceImpl();
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Miaou";
            System.out.println("Enregistrement de l'objet avec l'url : " + url);
            Naming.rebind(url, informationImpl);

            System.out.println("Serveur lancé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
