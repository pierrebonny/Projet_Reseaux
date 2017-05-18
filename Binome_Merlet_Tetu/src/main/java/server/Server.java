package server;

import server.model.IdeaManager;

import java.io.IOException;
import java.rmi.Naming;


/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Server {

        public static void main(String[] argv) {
            try {
                System.out.println("Création de l'objet serveur...");
                RequestInterface ideaManager = new IdeaManager();
                System.out.println("Référencement dans l'annuaire RMI");
                Naming.rebind("RequestInterface",ideaManager);
                System.out.println("Attente d'invocation - CTRL + C pour stopper");
                /*while (true) {
                    ServerThread thread = new ServerThread(Optional.of(socketserver.accept()));
                    thread.run();
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
