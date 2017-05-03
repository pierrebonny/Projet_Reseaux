import java.util.ArrayList;
import java.util.List;

/**
 * @author : thomas
 * @version : 03/05/17
 */
public class IdeaManager {
    private List<Idea> ideas = null;

    public IdeaManager() {
        ideas = new ArrayList<>();
    }

    public void addIdea(Idea idea){
        this.ideas.add(idea);
    }

    public List<Idea> getIdeas() {
        return ideas;
    }
}
