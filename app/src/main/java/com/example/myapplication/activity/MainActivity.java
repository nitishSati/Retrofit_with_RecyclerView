package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.RecyclerViewAdapter;
import com.example.myapplication.model.Country;
import com.example.myapplication.interfaces.CountryApiInterface;
import com.example.myapplication.model.CountryList;
import com.example.myapplication.R;
import com.example.myapplication.RetrofitExample;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView dataholder;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        CountryApiInterface countryApiInterface = RetrofitExample.getRetrofitExample().create(CountryApiInterface.class);
        Call<Country> call = countryApiInterface.getCountries();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                Country country = response.body();
                ArrayList<CountryList> countryLists = country.getCountries();
                adapter = new RecyclerViewAdapter(countryLists, MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                dataholder.setText(t.getMessage());

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
