package commands;

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
    public void interpret() {
       try {
           for (int i = 1; i < 6; i++) {
               System.out.println(params[i]);
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


