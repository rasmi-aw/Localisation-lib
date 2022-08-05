package com.beastwall.localisation.model.complex_fields;

import com.beastwall.localisation.service.Endpoint;
import lombok.Getter;

/**
 * @author Abdel Wadoud Rasmi
 */
public enum Form {
    RECTANGLE(Endpoint.COUNTRY_FLAG_RECTANGLE),
    SQUARE(Endpoint.COUNTRY_FLAG_SQUARE);

    private final String value;

    /**
     * constructor
     */
    Form(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }
}
