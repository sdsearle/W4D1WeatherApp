package com.example.admin.w4d1weatherapp;

import com.example.admin.w4d1weatherapp.openweather.WeatherForecast;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by admin on 9/18/2017.
 */

public class RetrofitHelper {
    private static final String BASE_URL = "http://samples.openweathermap.org";

    public static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;

    }

    //create a static method to ues the interface verbs
    public static Call<WeatherForecast> createWeatherCall(String city){
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        //return apiService.getWeatherForecast("Mesa,Us", "1bdd3727141c954decdeeba49f1db9ab");
        return apiService.getWeatherForecast();

    }

    //create an interface to have all the paths and verbs for the REST api to use
    interface ApiService{

        @GET("/data/2.5/forecast?q=Mesa,Us&appid=1bdd3727141c954decdeeba49f1db9ab")
        Call<WeatherForecast> getWeatherForecast();/*@Query("q") String city,
                                                       @Query("appid") String appid);*/

    }

}
