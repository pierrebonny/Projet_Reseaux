package network.server;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonParser {
    private JSONArray ideas;

    public JsonParser() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject root = (JSONObject)parser.parse(new FileReader("Binome_Casa_Bonny/res/data.json"));
            ideas = (JSONArray)root.get("ideas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String serializeIdeas() {
        StringBuilder sb = new StringBuilder();
        JSONObject jObject;
        for (int i = 0; i < ideas.size(); i++) {
            jObject = (JSONObject)ideas.get(i);

            sb.append("===========================\nIdée ").append(i+1);
            sb.append("\nNom : ").append(jObject.get("name"));
            sb.append("\nDescription : ").append(jObject.get("description"));
            sb.append("\nTechnologies : ").append(jObject.get("technology"));
            sb.append("\nCréateur :\n\tNom : ").append(((JSONObject)jObject.get("creator")).get("name"));
            sb.append("\n\tMail : ").append(((JSONObject)jObject.get("creator")).get("mail"));
            sb.append("\nFinalisé : ").append(jObject.get("finalised")).append("\n");
        }
        sb.append("===========================");
        return sb.toString();
    }

    public String serializeIdea(int ideaNumber) {
        if (ideaNumber >= ideas.size()) {
            return null;
        }
        JSONObject ideaJson = (JSONObject)ideas.get(ideaNumber);

        StringBuilder answer = new StringBuilder();
        answer.append("Idée : ").append(ideaJson.get("name")).append("\n");
        answer.append("Participants : \n");
        answer.append("\tFondateur : ").append(((JSONObject)ideaJson.get("creator")).get("mail")).append("\n");

        for (Object student : (JSONArray)ideaJson.get("participants")) {
            answer.append("\t- ").append(student.toString()).append("\n");
        }

        return answer.toString();
    }
}
