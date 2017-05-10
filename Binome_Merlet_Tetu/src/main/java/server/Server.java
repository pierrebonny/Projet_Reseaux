package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;


/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Server {

        public static void main(String[] argv) {
            ServerSocket socketserver  ;
            try {
                socketserver = new ServerSocket(15042);
                while (true) {
                    ServerThread thread = new ServerThread(Optional.of(socketserver.accept()));
                    thread.run();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
