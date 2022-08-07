import com.beastwall.localisation.Localisation;
import com.beastwall.localisation.model.City;
import com.beastwall.localisation.model.Country;
import com.beastwall.localisation.model.State;
import com.beastwall.localisation.model.complex_fields.Form;

import java.util.List;

/**
 * @author AbdelWadoud Rasmi
 */
public class Main {
    public static void main(String[] args) {
        // Fetch all countries using httpclient
        List<Country> countries = Localisation.getAllCountriesStatesAndCities();

        for (Country country : countries) {
            //Get countries Svg flag
            byte[] countryFlag = Localisation.getCountryFlagSVG(country.getIso2(), Form.SQUARE);

            //Get states for country
            List<State> states = country.getStates();

            for (State state : states) {
                //Get cities for a state
                List<City> cities = state.getCities();
            }
        }

        //Get Countries Only
        List<Country> countriesList = Localisation.getCountriesList();

        //Get countries Svg flag
        int i = 0;
        for (Country c : countries) {
            byte[] countryFlag = Localisation.getCountryFlagSVG(c.getIso2(), Form.SQUARE);
            //Do something like saving the file
        }

        //Get Algeria's flag with code "dz"
        byte[] dz = Localisation.getCountryFlagSVG("dz", Form.RECTANGLE);
    }


}
