package server;

import java.io.*;

import java.net.ServerSocket;

import java.net.Socket;



/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Server {

        public static void main(String[] argv) {
            ServerSocket socketserver  ;
            Socket socketduserveur ;
            try {
                socketserver = new ServerSocket(15042);
                socketduserveur = socketserver.accept();
                System.out.println("Un client s'est connecté !");

                PrintWriter writer = new PrintWriter(socketduserveur.getOutputStream());
                BufferedReader reader = new BufferedReader (new InputStreamReader(socketduserveur.getInputStream()));

                String message_distant = reader.readLine();
                System.out.println("Le client dit : " + message_distant);

                writer.println("Salut je suis le serveur !");
                writer.flush();

                writer.close();
                reader.close();
                socketserver.close();
                socketduserveur.close();

            }catch (IOException e) {

                e.printStackTrace();

            }

        }


    }
