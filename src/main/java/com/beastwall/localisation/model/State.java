package com.beastwall.localisation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 * <p>
 */
@AllArgsConstructor
@NoArgsConstructor
public class State {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String state_code;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String latitude;

    @Getter
    @Setter
    private String longitude;

    @Setter
    private List<City> cities;

    public List<City> getCities() {
        if(cities == null)
            cities = new ArrayList<>();
        return cities;
    }
}
