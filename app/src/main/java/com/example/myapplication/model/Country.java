
package com.example.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Serializable
{

    @SerializedName("countries")
    @Expose
    private ArrayList<CountryList> countries = null;
    private final static long serialVersionUID = 2571865646762086761L;

    public ArrayList<CountryList> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryList> countries) {
        this.countries = countries;
    }

}
