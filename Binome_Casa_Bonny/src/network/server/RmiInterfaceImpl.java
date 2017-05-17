package network.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiInterfaceImpl extends UnicastRemoteObject implements RmiInterface {
    private static final long serialVersionUID = 516541835163852L;

    protected RmiInterfaceImpl() throws RemoteException {
        super();
    }

    @Override
    public String accept(String mail, String idIdee) throws RemoteException {
        return "accept";
    }

    @Override
    public String add(String nom, String description, String techno, String nomCreateur, String mailCreateur) throws RemoteException {
        return "add";
    }

    @Override
    public String decline(String mail, String idIdee) throws RemoteException {
        return "decline";
    }

    @Override
    public String finalizes(String idIdee) throws RemoteException {
        return "finalize";
    }

    @Override
    public String getEtus(String idIdee) throws RemoteException {
        return "getEtus";
    }

    @Override
    public String getIdeas() throws RemoteException {
        return "getIdeas";
    }

    @Override
    public String join(String idIdee, String mail) throws RemoteException {
        return "join";
    }

    @Override
    public String quit() throws RemoteException {
        return "quit";
    }

    @Override
    public String sub(String mail) throws RemoteException {
        return "sub";
    }
}
