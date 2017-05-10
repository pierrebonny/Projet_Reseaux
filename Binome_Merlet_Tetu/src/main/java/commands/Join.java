package commands;

import model.IdeaManager;

public class Join implements Command {

    private String[] params;
    private boolean error = false;
    public Join(String[] params) {
        this.params = params;
    }

    @Override
    public void interpret(IdeaManager ideaManager) {
        try {
            if (params.length != 3){
                error = true;
            } else{
                int ideaID = Integer.valueOf(params[1].split("=")[1]);
                String mail = params[2].split("=")[1];
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
}


