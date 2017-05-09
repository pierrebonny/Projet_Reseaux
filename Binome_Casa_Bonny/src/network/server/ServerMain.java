package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;


/**
 * @author : thomas
 * @version : 03/05/17
 */
public class ServerMain {

        public static void main(String[] argv) {
            ServerSocket socketserver  ;
            try {
                socketserver = new ServerSocket(15042);
                while (true) {
                    ServerThread serverThread = new ServerThread(Optional.of(socketserver.accept()));
                    serverThread.run();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
