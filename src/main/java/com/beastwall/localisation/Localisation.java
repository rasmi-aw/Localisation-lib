package com.beastwall.localisation;

import com.beastwall.localisation.model.Country;
import com.beastwall.localisation.model.complex_fields.Form;
import com.beastwall.localisation.service.Endpoint;
import com.google.gson.Gson;
import com.google.inject.internal.util.Lists;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
            if (countries != null)
                return Arrays.asList(countries);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Returns the list of all countries without their states and cities
     */
    public static List<Country> getCountriesList() {
        //
        try {
            String json = getJson(Endpoint.COUNTRY);
            if (json == null)
                throw new Exception("Couldn't Fetch data, check your internet connection.");
            //
            Gson gson = new Gson();
            Country[] countries = gson.fromJson(json, Country[].class);
            if (countries != null)
                return Arrays.asList(countries);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
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
        return new String(getFile(url), StandardCharsets.UTF_8);
    }

    /**
     * Excecutes an http request to read a file
     */
    private static final byte[] getFile(String url) throws Exception {
        //
        HttpURLConnection urlConnection = ((HttpURLConnection) new URL(url).openConnection());
        //
        DataInputStream inputStream = new DataInputStream(urlConnection.getInputStream());
        byte[] bytes = new byte[urlConnection.getContentLength()];
        int size;
        int level = 0;
        inputStream.readFully(bytes);
        inputStream.close();
        inputStream = null;
        urlConnection = null;
        return bytes;
    }

}
