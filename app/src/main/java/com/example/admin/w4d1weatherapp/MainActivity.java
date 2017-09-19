package com.example.admin.w4d1weatherapp;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.w4d1weatherapp.openweather.List;
import com.example.admin.w4d1weatherapp.openweather.Weather;
import com.example.admin.w4d1weatherapp.openweather.WeatherForecast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  WeatherFragment.OnFragmentInteractionListener{

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=Mesa&APPID=1bdd3727141c954decdeeba49f1db9ab";
    private static final String TAG = "TAG";
    MyPageAdapter pageAdapter;
    java.util.List forecasts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final java.util.List weatherFragments = new ArrayList<>();

        final retrofit2.Call<WeatherForecast> callRepos
                = RetrofitHelper.createWeatherCall("Mesa");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    WeatherForecast forecast = callRepos.execute().body();
                    Log.d(TAG, "run: " + forecast);

                    //List<List> list = forecast.getList();
                    java.util.List<List> list = forecast.getList();
                    java.util.List<Weather> weathers = list.get(0).getWeather();

                    Log.d(TAG, "run: " + weathers.get(0).getDescription());


                    for (List wl: list
                         ) {
                        weatherFragments.add(WeatherFragment.newInstance(wl));
                    }
                    Log.d(TAG, "run: done");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pageAdapter = new MyPageAdapter(getSupportFragmentManager(), weatherFragments);
                            ViewPager pager =
                                    (ViewPager)findViewById(R.id.vpWeatherFrag);
                            pager.setAdapter(pageAdapter);
                            Log.d(TAG, "onCreate: ");
                            //pager.setAdapter(pageAdapter);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
