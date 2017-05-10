package commands;

/**
 * @author : thomas
 * @version : 10/05/17
 */
public interface Command {

    void interpret();

    String result();
}
