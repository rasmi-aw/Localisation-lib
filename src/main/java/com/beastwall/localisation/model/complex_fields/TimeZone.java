package com.beastwall.localisation.model.complex_fields;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author AbdelWadoud Rasmi
 * <p>
 * time zone definition
 */
@AllArgsConstructor
@NoArgsConstructor
public class TimeZone {

    @Getter
    @Setter
    private String zoneName;

    @Getter
    @Setter
    private Integer gmtOffset;

    @Getter
    @Setter
    private String gmtOffsetName;

    @Getter
    @Setter
    private String abbreviation;

    @Getter
    @Setter
    private String tzName;

}