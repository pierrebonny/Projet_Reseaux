package server;

import model.IdeaManager;

import java.net.Socket;
import java.util.Optional;

public class ServerThread implements Runnable{

    private Optional<Socket> socket;
    private IdeaManager manager;

    public ServerThread(Optional<Socket> socket, IdeaManager ideaManager){
        this.socket = socket;
        this.manager = ideaManager;
    }

    @Override
    public void run() {
        if(socket.isPresent()){

            Thread t = new Thread(new Authentification(socket.get()));
            t.start();
        }
    }
}
