package commands;

import server.model.Idea;
import server.model.IdeaManager;

/**
 * @author : thomas
 * @version : 10/05/17
 */
public class GetEtus implements Command {

    private String[] params;
    private boolean error = false;
    private int ideaID;
    private Idea idea;

    public GetEtus(String[] params) {
        this.params = params;
    }

    @Override
    public void interpret(IdeaManager ideaManager) {
        try{
            ideaID = Integer.valueOf(getParam(params, "idIdée").split("=")[1]);
            idea = ideaManager.getIdea(ideaID);
        }catch (Exception e){
            error = true;
        }
    }

    @Override
    public String result() {
        return (error == true)? "ERREUR: Requete GET_ETUS invalide." : ("OK" + idea.supportersToString());
    }

    @Override
    public String resultServer() {
        return (error == true)? "ERREUR: LISTING STUDENTS FAILED." : "LISTING STUDENTS SUCCESSFULL";
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
