package com.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {
            "NEPAL", "KATHMANDU",
            "INDIA", "NEW DELHI",
            "CHINA",  "BEIJING",
            "UK",     "LONDON",
            "US",     "WASHINGTON, D.C.",
            "CANADA", "OTTAWA",
    };
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView countries1 = findViewById(R.id.countryList);

        dictionary = new HashMap<>();
        for (int i=0;i<countries.length;i+=2){
            dictionary.put(countries[i],countries[i+1]);
        }

        ArrayAdapter countriesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())

        );
        countries1.setAdapter(countriesAdapter);
        countries1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String Key = parent.getItemAtPosition(position).toString();
               String meaning = dictionary.get(Key);

                Intent intent = new Intent(MainActivity.this,capitalActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });
    }
}
