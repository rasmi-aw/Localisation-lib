package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Getter
    @Setter
    private City[] cities;


}
