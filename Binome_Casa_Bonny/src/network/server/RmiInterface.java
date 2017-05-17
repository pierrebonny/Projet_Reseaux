package network.server;

import java.rmi.*;

public interface RmiInterface extends Remote {
    /**
     *
     *
     * @param mail
     * @param idIdee
     * @return
     * @throws RemoteException
     */
    String accept(String mail, String idIdee) throws RemoteException;

    String add(String nom, String description, String techno, String nomCreateur, String mailCreateur) throws RemoteException;

    String decline(String mail, String idIdee) throws RemoteException;

    String finalizes(String idIdee) throws RemoteException;

    String getEtus(String idIdee) throws RemoteException;

    String getIdeas() throws RemoteException;

    String join(String idIdee, String mail) throws RemoteException;

    String quit() throws RemoteException;

    String sub(String mail) throws RemoteException;
}
