package commands;

/**
 * @author : thomas
 * @version : 17/05/17
 */
public enum Commands {

    ADD("ADD", new String[]{"Nom","Description","Technologie","Nom du Créateur","Mail du créateur"}),
    JOIN("JOIN",new String[]{"Id de l'idée","Votre mail"}),
    GET_ETUS("GET_ETUS",new String[]{"Id de l'idée"}),
    GET_IDEAS("GET_IDEAS",new String[]{}),
    HELP("HELP",new String[]{}),
    QUIT("QUIT",new String[]{});

    private String s;
    private String[] params;

    Commands(String s,String[] params) {
        this.params = params;
        this.s = s;
    }

    public String[] getParams() {
        return params;
    }

    public String getS() {
        return s;
    }

    public static boolean isCommand(String command){
        return valueOf(command)!=null;
    }
}
