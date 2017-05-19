package server.model;

import server.RequestInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class IdeaManager extends UnicastRemoteObject implements RequestInterface{

    private List<Idea> ideas = null;

    public IdeaManager() throws RemoteException {
        super();
        ideas = new ArrayList<>();
    }

    public void addIdea(Idea idea){
        this.ideas.add(idea);
    }

    public Idea getIdea(int index){
        return this.ideas.get(index-1);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("---------------------------------\n");
        for(int i =0;i<ideas.size();i++){
            Idea idea = ideas.get(i+1);
            s.append("Idée " + i +" :\n");
            s.append("Nom : " + idea.getName() +"\n");
            s.append("Description : "+ idea.getDescription()+ "\n");
            s.append("Technologie : " + idea.getTechnology()+"\n");
            s.append("Créateur : \n\t"+ idea.getNomCreator() +"\n\t" );
            s.append(idea.getMailCreator() +"\n");
            s.append("Finalisé : " + idea.isProject()+"\n");
            s.append("---------------------------------\n");
        }
        System.out.println(s.toString());
        return s.toString();
    }

    @Override
    public String add(String name, String description, String technos, String nomCreator, String mailCreator) throws RemoteException {
        this.addIdea(new Idea(name,description,technos,nomCreator,mailCreator));
        return "OK\n";
    }

    @Override
    public String getIdeas() throws RemoteException {
        return this.toString();
    }

    @Override
    public String join(int idIdea, String mail) throws RemoteException {
        Idea idea = getIdea(idIdea);
        idea.addSupporters(mail);
        return "OK\n";
    }

    @Override
    public String getStudents(int idIdea) throws RemoteException {
        Idea idea = getIdea(idIdea);
        return idea.supportersToString();
    }
}
