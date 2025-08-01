import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import com.google.gson.*;

public class ExchangeRateClient {
    private final String API_KEY;
    private final HttpClient client;
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public ExchangeRateClient(String apiKey) {
        this.API_KEY = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    public ExchangeRateResponse getRates(String baseCurrency) throws IOException, InterruptedException {
        String endpoint = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }
}
