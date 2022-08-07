package com.beastwall.localisationdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.countries_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //
        new Thread(() -> {
            List<Country> countries = Localisation.getAllCountriesStatesAndCities();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setAdapter(new CountriesAdapter(countries));
                }
            });
        }).start();

    }


}