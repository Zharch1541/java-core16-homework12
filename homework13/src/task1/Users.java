package task1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Users {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        int id = 2;
        String username = "Samantha";

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        if (getResponse.statusCode() == 200) {
            System.out.println("Users information: " + getResponse.body());
        } else {
           System.out.println("Failed to retrieve users. Response code: " + getResponse.statusCode());
        }



        HttpRequest getIdRequest = HttpRequest.newBuilder()
                .uri(new URI(uri + "/" + id))
                .GET()
                .build();


        HttpClient httpClient1 = HttpClient.newHttpClient();
        HttpResponse<String> getIdResponse = httpClient1.send(getIdRequest, HttpResponse.BodyHandlers.ofString());

        if (getIdResponse.statusCode() == 200) {
            System.out.println("Users information by ID: " + getIdResponse.body());
        } else {
            System.out.println("Failed to retrieve user. Response code: " + getIdResponse.statusCode());
        }



        HttpRequest getUsernameRequest = HttpRequest.newBuilder()
                .uri(new URI(uri + "?username=" + username))
                .GET()
                .build();

        HttpClient httpClient2 = HttpClient.newHttpClient();
        HttpResponse<String> getUsernameResponse = httpClient2.send(getUsernameRequest, HttpResponse.BodyHandlers.ofString());

        if (getUsernameResponse.statusCode() == 200) {
            System.out.println("Users information by Username: " + getUsernameResponse.body());
        } else {
            System.out.println("Failed to retrieve user. Response code: " + getUsernameResponse.statusCode());
        }

    }
}
