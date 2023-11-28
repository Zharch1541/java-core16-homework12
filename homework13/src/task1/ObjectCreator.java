package task1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectCreator {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        String file = "C:\\Users\\38063\\IdeaProjects\\homework13\\src\\users\\new_user.json";
        String user = readFileAsString(file);



        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/users"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(user))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("postResponse.body() = " + postResponse.body());

    }

    public static String readFileAsString(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
