package com.blacksoft.localisation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author AbdelWadoud Rasmi
 */
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String latitude;

    @Getter
    @Setter
    private String longitude;
}
