package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{
    private TextView dataholder;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   dataholder=findViewById(R.id.textviewdata);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        CountryApiInterface countryApiInterface= RetrofitExample.getRetrofitExample().create(CountryApiInterface.class);
        Call<Country> call=countryApiInterface.getCountries();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                Country country=response.body();
                ArrayList<CountryList> countryLists=country.getCountries();
                adapter=new RecyclerViewAdapter(countryLists,MainActivity.this,MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

 /*               for (CountryList countryList:countryLists){
                    String content="";
                    content+=countryList.getId()+"\n";
                    content+=countryList.getSortname()+"\n";
                    content+=countryList.getName()+"\n";
                    content+=countryList.getPhoneCode()+"\n\n";
                    dataholder.append(content);

                }
   */         }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                dataholder.setText(t.getMessage());

            }
        });
    }

    @Override
    public void click(int position) {

    }
}
