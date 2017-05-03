package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

public class ServerThread implements Runnable{

    private Optional<Socket> socket;

    public ServerThread(Optional<Socket> socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        if(socket.isPresent()){
            System.out.println("Un client s'est connecté !");

            try {
                PrintWriter writer = new PrintWriter(socket.get().getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.get().getInputStream()));

                String message_distant = reader.readLine();
                System.out.println("Le client dit : " + message_distant);

                writer.println("Salut je suis le serveur !");
                writer.flush();

                writer.close();
                reader.close();
                socket.get().close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
