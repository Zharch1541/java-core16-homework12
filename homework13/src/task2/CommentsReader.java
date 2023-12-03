package task2;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CommentsReader {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/10/comments"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        if (getResponse.statusCode() != 200) {
            System.out.println("Response code" + getResponse.statusCode());
        }


        JsonArray jsonArray = JsonParser.parseString(getResponse.body()).getAsJsonArray();

        List<JsonObject> comments = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String body = jsonObject.get("body").getAsString();
            String id = jsonObject.get("id").getAsString();

            JsonObject comment = new JsonObject();

            comment.addProperty("id", id);
            comment.addProperty("body", body);
            comments.add(comment);
        }

        for (JsonObject comment: comments) {
            System.out.println(comment);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter write =  new FileWriter("user-1-post-10-comments.json");
        write.write(gson.toJson(comments));
        write.close();
    }

    }
