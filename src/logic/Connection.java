package logic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class Connection {
    private static final String KEY = "454a85a284acf62b4746a45f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + KEY;
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static String currentUrl = BASE_URL;
    private static HttpResponse<String> response;


    private static void fetchInitialData() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(currentUrl))
                .build();
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void changeUrl(String urlExtend) {
        currentUrl = BASE_URL + urlExtend; // Actualizar url con nuevo valor
        fetchInitialData();
    }

    public static String responseBody() {
        if (response != null && response.body() != null) {
            return response.body();
        } else {
            return "Could not get answer";
        }
    }

    public static String getCurrentUrl() {
        return currentUrl;
    }
}
