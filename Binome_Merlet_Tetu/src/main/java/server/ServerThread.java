package server;

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

            Thread t = new Thread(new Authentification(socket.get()));
            t.start();
        }
    }
}
