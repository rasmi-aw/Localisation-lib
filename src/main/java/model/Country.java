package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.complex_fields.TimeZone;
import model.complex_fields.Translations;

/**
 * @author AbdelWadoud Rasmi
 */
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String iso3;

    @Getter
    @Setter
    private String iso2;

    @Getter
    @Setter
    private String numeric_code;

    @Getter
    @Setter
    private String phone_code;

    @Getter
    @Setter
    private String capital;

    @Getter
    @Setter
    private String currency;

    @Getter
    @Setter
    private String currency_name;

    @Getter
    @Setter
    private String currency_symbol;

    @Getter
    @Setter
    private String tld;

    @Getter
    @Setter
    @SerializedName("native")
    private String nativeL;

    @Getter
    @Setter
    private String region;

    @Getter
    @Setter
    private String subregion;

    @Getter
    @Setter
    private TimeZone[] timezones;

    @Getter
    @Setter
    private Translations translations;

    @Getter
    @Setter
    private String latitude;

    @Getter
    @Setter
    private String longitude;

    @Getter
    @Setter
    private String emoji;

    @Getter
    @Setter
    private String emojiU;

    @Getter
    @Setter
    private State[] states;


}
