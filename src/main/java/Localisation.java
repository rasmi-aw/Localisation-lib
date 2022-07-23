import model.Country;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.GeographyService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 */
public class Localisation {
    private static final String BASE_URL = "https://raw.githubusercontent.com/rasmi-aw/localisation/master/";


    /**
     * Returns the list of all countries along with their states and cities
     */
    public static List<Country> getAllCountriesStatesAndCities() throws IOException {

        GeographyService service = buildRequest(BASE_URL).create(GeographyService.class);
        Call<List<Country>> call = service.getAllCountriesStatesAndCities();
        //
        System.out.println(new Date() + " --Blacksoft.Localisation-- Started fetch_countries request");
        Response<List<Country>> response = call.execute();
        if (response.body() != null)
            System.out.println(new Date() + " --Blacksoft.Localisation-- Finished fetching all number countries".replace("number", String.valueOf(response.body().size())));
        else
            System.err.println(new Date() + " --Blacksoft.Localisation-- An Error has occurred while fetching countries");
        return response.body();
    }


    /**
     * Excecutes an http request
     */
    private static final Retrofit buildRequest(String url) {

        //
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build()).build();

        return retrofit;
    }

}
