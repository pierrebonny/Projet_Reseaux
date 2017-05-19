package client;

import commands.Commands;
import server.RequestInterface;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Client {
    public static void main(String[] argv) {

        try {
            //System.setSecurityManager(new RMISecurityManager());
            System.out.println("Recherche de l'objet Serveur ...");
            RequestInterface requestInterface = (RequestInterface) Naming.lookup("rmi://localhost/RequestInterface");
            displayCommands();
            while(true) {
                System.out.println("Entrez la commande désirée :");
                Scanner scanner = new Scanner(System.in);
                String command = scanner.nextLine();
                List<String> params = new ArrayList<>();
                Commands commands;
                try {
                    commands = Commands.valueOf(command);
                }catch (Exception e){
                    commands = null;
                }
                if (commands != null) {
                    for (String param : commands.getParams()) {
                        System.out.println(param + ":");
                        params.add(scanner.nextLine());
                    }

                    System.out.println("Invocation de la méthode " + commands.getS());
                    String result;
                    switch (commands) {
                        case ADD:
                            result = requestInterface.add(params.get(0), params.get(1), params.get(2), params.get(3), params.get(4));
                            break;
                        case JOIN:
                            try {
                                result = requestInterface.join(Integer.parseInt(params.get(0)), params.get(1));
                            }catch (Exception e){
                                result = "ERREUR : Idée n°" +params.get(0)+" inexistante";
                            }
                            break;
                        case GET_ETUS:
                            try {
                            result = requestInterface.getStudents(Integer.parseInt(params.get(0)));
                            }catch (Exception e){
                            result = "ERREUR : Idée n°" +params.get(0)+" inexistante";
                            }
                            break;
                        case GET_IDEAS:
                            result = requestInterface.getIdeas();
                            break;
                        case FINALIZE:
                            try {
                            result = requestInterface.finalize(Integer.parseInt(params.get(0)));
                            }catch (Exception e){
                                result = "ERREUR : Idée n°" +params.get(0)+" inexistante";
                           }
                            break;
                        case DELETE:
                            try {
                            result = requestInterface.delete(Integer.parseInt(params.get(0)));
                            }catch (Exception e){
                                result = "ERREUR : Idée n°" +params.get(0)+" inexistante";
                            }
                            break;
                        case HELP:
                            displayCommands();
                            result = "";
                            break;
                        case QUIT:
                            System.exit(0);
                        default:
                            result = "ERREUR";
                            break;
                    }
                    System.out.println(result);
                }else {
                    System.out.println("ERREUR : commande invalide");
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        } catch (NotBoundException e) {
            e.printStackTrace();}

    }

    private static void displayCommands(){
        System.out.println("Voici la liste des commandes disponibles : ");
        for (Commands c : Commands.values()) {
            System.out.println(c.getS());
        }
    }
}
