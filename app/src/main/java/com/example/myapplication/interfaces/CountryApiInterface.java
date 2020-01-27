package com.example.myapplication.interfaces;

import com.example.myapplication.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApiInterface {
    @GET("countries.json")
    Call<Country> getCountries();
}
