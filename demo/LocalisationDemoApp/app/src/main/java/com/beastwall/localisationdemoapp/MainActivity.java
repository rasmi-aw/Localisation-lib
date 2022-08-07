package com.beastwall.localisationdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.beastwall.localisation.Localisation;
import com.beastwall.localisation.model.Country;
import com.beastwall.localisation.model.complex_fields.Form;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author AbdelWadoud Rasmi
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        new Thread(() -> {
            byte[] dz = Localisation.getCountryFlagSVG("DZ", Form.SQUARE);
            List<Country> countries = Localisation.getAllCountriesStatesAndCities();
            Log.v("rasmi", "" + countries.size());
        }).start();

    }


}