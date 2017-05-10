package commands;

import model.Idea;
import model.IdeaManager;

/**
 * @author : thomas
 * @version : 10/05/17
 */
public class Add implements Command {

    private String[] params;
    private boolean error = false;
    public Add(String[] params) {
        this.params = params;
    }

    @Override
    public void interpret(IdeaManager ideaManager) {
       try {
           if (params.length !=6){
               error = true;
           }else{
               String name = params[1].split("=")[1];
               String description = params[2].split("=")[1];
               String technology = params[3].split("=")[1];
               String nomCreateur = params[4].split("=")[1];
               String mailCréateur = params[5].split("=")[1];
               ideaManager.addIdea(new Idea(name,description,technology,nomCreateur,mailCréateur));
           }
       }catch (Exception e){
           error = true;
       }
    }

    @Override
    public String result() {
        return (error == true)? "ERREUR: Requete ADD invalide." : "OK";
    }
}


