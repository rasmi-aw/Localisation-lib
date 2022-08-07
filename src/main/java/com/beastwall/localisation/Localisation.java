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
        int fileSize = urlConnection.getContentLength();
        byte[] bytes;
        if (fileSize > 0) {
            bytes = new byte[fileSize];
            inputStream.readFully(bytes);
        } else {
            // for android since getContentLength() returns -1
            ArrayList<byte[]> allBytes = new ArrayList<>();
            bytes = new byte[32 * 1024];
            int size = 0;
            int totalSize = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                byte[] read = Arrays.copyOf(bytes, size);
                totalSize += size;
                allBytes.add(read);
            }
            //
            bytes = new byte[totalSize];
            totalSize = 0;
            for (int i = 0; i < allBytes.size(); i++) {
                byte[] read = allBytes.get(i);
                int length = read.length;
                System.arraycopy(read, 0, bytes, totalSize, length);
                totalSize += length;
            }
        }
        //
        inputStream.close();
        inputStream = null;
        urlConnection = null;
        return bytes;
    }

}
