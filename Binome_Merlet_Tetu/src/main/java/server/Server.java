package server;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;



/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Server {

        public static void main(String[] zero) {
            ServerSocket socketserver  ;
            Socket socketduserveur ;
            try {
                socketserver = new ServerSocket(2009);
                socketduserveur = socketserver.accept();
                System.out.println("Un zéro s'est connecté !");
                socketserver.close();
                socketduserveur.close();

            }catch (IOException e) {

                e.printStackTrace();

            }

        }


    }
