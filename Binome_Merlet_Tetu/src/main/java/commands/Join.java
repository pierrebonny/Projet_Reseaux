package commands;

import model.IdeaManager;

public class Join implements Command {

    private String[] params;
    private boolean error = false;
    private int ideaID;
    public Join(String[] params) {
        this.params = params;
    }

    @Override
    public void interpret(IdeaManager ideaManager) {
        try {
            if (params.length != 3){
                error = true;
            } else{
                ideaID = Integer.valueOf(getParam(params, "idIdée").split("=")[1]);
                String mail = getParam(params, "mail").split("=")[1];
                ideaManager.getIdea(ideaID).addSupporters(mail);
            }
        }catch (Exception e){
            error = true;
        }
    }

    @Override
    public String result() {
        return (error == true)? "ERREUR: Requete JOIN invalide." : "OK";
    }

    @Override
    public String resultServer() {
        return (error == true)? "ERREUR: Adding idea failed." : ("JOINING IDEA :" + ideaID + " SUCCESSFULL");
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


