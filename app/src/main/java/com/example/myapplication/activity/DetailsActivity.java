package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Country;
import com.example.myapplication.model.CountryList;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    ArrayList<CountryList> countryLists = new ArrayList<>();
    Integer pos = -1;
    TextView id, name, sortname, phonecode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        id = findViewById(R.id.textviewId);
        pos = getIntent().getIntExtra("position", -1);
        sortname = findViewById(R.id.textviewSortname);
        name = findViewById(R.id.textviewName);
        phonecode = findViewById(R.id.textviewPhonecode);
        if (pos != -1) {

            countryLists = (ArrayList<CountryList>) getIntent().getSerializableExtra("countryData");
            id.setText(String.valueOf(countryLists.get(pos).getId()));
            sortname.setText(countryLists.get(pos).getSortname());
            name.setText(countryLists.get(pos).getName());
            phonecode.setText(String.valueOf(countryLists.get(pos).getPhoneCode()));
        }
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
