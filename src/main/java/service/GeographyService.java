package service;

import model.Country;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 *
 * Represents the set of endpoints used to fetch
 * countries, states and cities data from github repository
 */
public interface GeographyService {


    @GET("countries+states+cities.json")
    Call<List<Country>> getAllCountriesStatesAndCities();
}
