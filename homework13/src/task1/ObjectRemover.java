package task1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObjectRemover {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        HttpRequest removeRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/users/8"))
                .DELETE()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(removeRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 200) {
            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("Remove successful.");
        } else {
            System.out.println("Remove failed. Response code: " + response.statusCode());
        }

    }

}
