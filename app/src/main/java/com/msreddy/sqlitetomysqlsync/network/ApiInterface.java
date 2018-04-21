package com.msreddy.sqlitetomysqlsync.network;

/**
 * Created by meghanthan on 4/20/2018.
 */

import com.msreddy.sqlitetomysqlsync.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("weather?q=London,uk;appid=b6907d289e10d714a6e88b30761fae22")
    Call<Example> getCoord();
    @GET("weather?q=London,uk;appid=b6907d289e10d714a6e88b30761fae22")
    Call<Example> getWeather();
    @GET("weather?q=London,uk;appid=b6907d289e10d714a6e88b30761fae22")
    Call<Example> clouds();
    @GET("weather?q=London,uk;appid=b6907d289e10d714a6e88b30761fae22")
    Call<Example> dt();
}