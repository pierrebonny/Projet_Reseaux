package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class Idea {
    private String name;
    private String description;
    private String technology;
    private String nomCreator;
    private String mailCreator;
    private List<String> supporters = null;
    private boolean project;

    public Idea(String name, String description, String technology, String nomCreator, String mailCreator) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.nomCreator = nomCreator;
        this.mailCreator = mailCreator;
        supporters = new ArrayList<>();
        supporters.add(mailCreator);
        project = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public String getNomCreator() {
        return nomCreator;
    }

    public String getMailCreator() {
        return mailCreator;
    }

    public boolean isProject() {
        return project;
    }

    public void setProject() {
        this.project = true;
    }

    public void addSupporters(String mailSupporter) {
        supporters.add(mailSupporter);
    }

    public String supportersToString(){
        StringBuilder s = new StringBuilder();
        s.append("Createur : " + this.getNomCreator() + "\n");
        for(String supp : supporters){
            s.append("----------------------------------\n");
            s.append(supp + "\n");
        }
        return s.toString();
    }
}

