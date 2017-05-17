package network.server;

import java.rmi.*;

public interface RmiInterface extends Remote {
    /**
     * Accepte l'inscription d'une personne à une idée à partir de son mail.
     *
     * @param mail Mail de l'étudiant
     * @param idIdee Identifiant de l'idée
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String accept(String mail, String idIdee) throws RemoteException;

    /**
     * Ajoute une idée dans le registre des idées.
     *
     * @param nom Nom de l'idée
     * @param description Description rapide du concept
     * @param techno Principale technologie utilisée
     * @param nomCreateur Nom du créateur de l'idée
     * @param mailCreateur Mail du créateur de l'idée
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String add(String nom, String description, String techno, String nomCreateur, String mailCreateur) throws RemoteException;

    /**
     * Décline l'inscription d'un étudiant à une idée.
     *
     * @param mail Mail de l'étudiant
     * @param idIdee Identifiant de l'idée
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String decline(String mail, String idIdee) throws RemoteException;

    /**
     * Déclare une idée comme étant un projet.
     *
     * @param idIdee Identifiant de l'idée
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String finalizes(String idIdee) throws RemoteException;

    /**
     * Liste les participants à une idée.
     *
     * @param idIdee Identifiant de l'idée.
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String getEtus(String idIdee) throws RemoteException;

    /**
     * Donne la liste de toutes les idées disponibles.
     *
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String getIdeas() throws RemoteException;

    /**
     * Permet à un étudiant de participer à une idée en renseignant son adresse mail.
     *
     * @param idIdee Identifiant de l'idée
     * @param mail Mail de l'étudiant
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String join(String idIdee, String mail) throws RemoteException;

    /**
     * Ferme la connexion au serveur.
     *
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String quit() throws RemoteException;

    /**
     * Inscrit un étudiant à une idée.
     *
     * @param mail Mail de l'étudiant à inscrire
     * @return OK si la requête a été correctement effectuée, une erreur sinon
     * @throws RemoteException Si une erreur arrive lors de la communication
     */
    String sub(String mail) throws RemoteException;
}
