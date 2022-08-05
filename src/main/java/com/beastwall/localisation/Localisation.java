package com.beastwall.localisation;

import com.beastwall.localisation.model.Country;
import com.beastwall.localisation.model.complex_fields.Form;
import com.beastwall.localisation.service.Endpoint;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 */
public class Localisation {
    private static final String TAG = "com.beastwall.localisation.Localisation";

    /**
     * Returns the list of all countries along with their states and cities
     */
    public static List<Country> getAllCountriesStatesAndCities() {
        //
        try {
            String json = getJson(Endpoint.COUNTRY_CITY_STATE);
            if (json == null)
                throw new Exception("Couldn't Fetch data, check your internet connection.");
            //
            Gson gson = new Gson();
            Country[] countries = gson.fromJson(json, Country[].class);
            return Arrays.asList(countries);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Return country flag in svg format
     *
     * @param code: country code
     * @param form: whether a rectangle or a Square see enum {@link Form}
     */
    public static byte[] getCountryFlagSVG(String code, Form form) {
        //
        try {
            String codeC = code.trim().toLowerCase();
            return getFile(form.toString().replace("dz", codeC));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Excecutes an http request
     */
    private static final String getJson(String url) throws Exception {
        //
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //
        return response.body();
    }

    /**
     * Excecutes an http request to read a file
     */
    private static final byte[] getFile(String url) throws Exception {
        //
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        //
        return response.body();
    }

}
