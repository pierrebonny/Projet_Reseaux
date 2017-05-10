package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class IdeaManager {
    private List<Idea> ideas = null;

    public IdeaManager() {
        ideas = new ArrayList<>();
    }

    public void addIdea(Idea idea){
        this.ideas.add(idea);
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public Idea getIdea(int index){
        return this.ideas.get(index);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("---------------------------------\n");
        for(int i =0;i<ideas.size();i++){
            Idea idea = ideas.get(i);
            s.append("Idée " + i +" :\n");
            s.append("Nom : " + idea.getName() +"\n");
            s.append("Description : "+ idea.getDescription()+ "\n");
            s.append("Technologie : " + idea.getTechnology()+"\n");
            s.append("Créateur : \n\t"+ idea.getNomCreator() +"\n\t" );
            s.append(idea.getMailCreator() +"\n");
            s.append("Finalisé : " + idea.isProject()+"\n");
            s.append("---------------------------------\n");
        }
        return s.toString();
    }
}
