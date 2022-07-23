import com.google.gson.Gson;
import model.Country;
import service.Endpoint;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 */
public class Localisation {

    /**
     * Returns the list of all countries along with their states and cities
     */
    public static List<Country> getAllCountriesStatesAndCities() throws Exception {
        //
        Gson gson = new Gson();
        String json = getJson(Endpoint.COUNTRY_CITY_STATE);
        if (json == null)
            throw new Exception("Couldn't Fetch data, check your internet connection.");
        Country[] countries = gson.fromJson(json, Country[].class);
        return Arrays.asList(countries);
    }


    /**
     * Excecutes an http request
     */
    private static final String getJson(String url) throws URISyntaxException, IOException, InterruptedException {

        //
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
