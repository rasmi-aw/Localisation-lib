package service;

/**
 * @author AbdelWadoud Rasmi
 * <p>
 * Represents the set of endpoints used to fetch
 * countries, states and cities data from github repository
 */
public interface Endpoint {
    String BASE_URL = "https://raw.githubusercontent.com/rasmi-aw/localisation/master/";
    String COUNTRY_CITY_STATE = BASE_URL + "countries+states+cities.json";
}
