import com.beastwall.localisation.Localisation;
import com.beastwall.localisation.model.City;
import com.beastwall.localisation.model.Country;
import com.beastwall.localisation.model.State;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Fetch all countries using httpclient
        List<Country> countries = Localisation.getAllCountriesStatesAndCities();

        //Get states for country
        if (countries != null && !countries.isEmpty()) {
            State[] states = countries.get(0).getStates();
            State state = states[0];

            //Get cities for a state
            if (state != null) {
                City city = state.getCities()[0];
            }
        }

        //
        byte[] dz = Localisation.getCountryFlagSVG("dz");
    }
}
