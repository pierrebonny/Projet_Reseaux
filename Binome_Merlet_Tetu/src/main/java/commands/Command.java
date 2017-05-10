package commands;

import model.IdeaManager;

/**
 * @author : thomas
 * @version : 10/05/17
 */
public interface Command {

    void interpret(IdeaManager ideaManager);

    String result();
}
