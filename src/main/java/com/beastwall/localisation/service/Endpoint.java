package com.beastwall.localisation.service;

/**
 * @author AbdelWadoud Rasmi
 * <p>
 * Represents the set of endpoints used to fetch
 * countries, states and cities data from github repository
 */
public interface Endpoint {
    String BASE_URL = "https://raw.githubusercontent.com/rasmi-aw/localisation/master/";
    String COUNTRY_CITY_STATE = BASE_URL + "countries+states+cities.json";

    String COUNTRY_FLAG_SQUARE = "https://raw.githubusercontent.com/rasmi-aw/flag-icons/main/flags/1x1/dz.svg";
    String COUNTRY_FLAG_RECTANGLE = "https://raw.githubusercontent.com/rasmi-aw/flag-icons/main/flags/4x3/dz.svg";

}
