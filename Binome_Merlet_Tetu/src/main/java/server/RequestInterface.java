package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : thomas
 * @version : 17/05/17
 */
public interface RequestInterface extends Remote {

    public String add(String name, String description,String technos,String nomCreator, String mailCreator) throws RemoteException;

    public String getIdeas() throws RemoteException;

    public String join(int idIdea,String mail) throws RemoteException;

    public String getStudents(int idIdea) throws RemoteException;

}
