package network.server;

import network.commands.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiInterfaceImpl extends UnicastRemoteObject implements RmiInterface {
    private static final long serialVersionUID = 516541835163852L;

    RmiInterfaceImpl() throws RemoteException {
        super();
    }

    @Override
    public String accept(String mail, String idIdee) throws RemoteException {
        String[] params = {"mail="+mail, "idIdée"+idIdee};
        return executeCommand(new Accept(), params);
    }

    @Override
    public String add(String nom, String description, String techno, String nomCreateur, String mailCreateur) throws RemoteException {
        String[] params = {"nom="+nom, "description="+description, "techno="+techno, "nomCréateur="+nomCreateur, "mailCréateur="+mailCreateur};
        return executeCommand(new Add(), params);
    }

    @Override
    public String decline(String mail, String idIdee) throws RemoteException {
        String[] params = {"mail="+mail, "idIdée="+idIdee};
        return executeCommand(new Decline(), params);
    }

    @Override
    public String finalizes(String idIdee) throws RemoteException {
        String[] params = {"idIdée="+idIdee};
        return executeCommand(new Finalize(), params);
    }

    @Override
    public String getEtus(String idIdee) throws RemoteException {
        String[] params = {"idIdée="+idIdee};
        return executeCommand(new GetEtus(), params);
    }

    @Override
    public String getIdeas() throws RemoteException {
        String[] params = {};
        return executeCommand(new GetIdeas(), params);
    }

    @Override
    public String join(String idIdee, String mail) throws RemoteException {
        String[] params = {"mail="+mail, "idIdée="+idIdee};
        return executeCommand(new Join(), params);
    }

    @Override
    public String quit() throws RemoteException {
        String[] params = {};
        return executeCommand(new Quit(), params);
    }

    @Override
    public String sub(String mail) throws RemoteException {
        String[] params = {"mail="+mail};
        return executeCommand(new Sub(), params);
    }

    private String executeCommand(Command command, String[] params) {
        command.parse(params);
        return command.serialize();
    }
}
