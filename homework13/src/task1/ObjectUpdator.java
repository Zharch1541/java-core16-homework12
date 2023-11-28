package task1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectUpdator {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        String file = "C:\\Users\\38063\\IdeaProjects\\homework13\\src\\users\\user9_updated.json";
        String user = readFileAsString(file);



        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/users/9"))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(user))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("postResponse.body() = " + response.body());

        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            System.out.println("Update successful.");
        } else {
            System.out.println("Update failed. Response code: " + response.statusCode());
        }

    }

    public static String readFileAsString(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
