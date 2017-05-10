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
               String name = getParam(params, "nom").split("=")[1];
               String description = getParam(params, "description").split("=")[1];
               String technology = getParam(params, "technos").split("=")[1];
               String nomCreateur = getParam(params, "nomCréateur").split("=")[1];
               String mailCréateur = getParam(params, "mailCréateur").split("=")[1];
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

    private String getParam(String[] params, String name){
        for(String param : params){
            if(param.contains(name)) {
                return param;
            }
        }
        return null;
    }
}


