package task3;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/users/1/todos"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        if (getResponse.statusCode() != 200) {
            System.out.println("Response code: " + getResponse.statusCode());
        }

        JsonArray jsonArray = JsonParser.parseString(getResponse.body()).getAsJsonArray();

        List<JsonObject> openTasks = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject task = jsonArray.get(i).getAsJsonObject();

            if (task.get("completed").getAsString() == "false") {
                openTasks.add(task);
            }
        }

        for (JsonObject openTask: openTasks) {
            System.out.println("openTask = " + openTask);
        }
    }
}
