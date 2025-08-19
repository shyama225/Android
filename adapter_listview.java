package com.example.adapterlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        listView = findViewById(R.id.listView);

        // Create ArrayAdapter using built-in simple_list_item_1 layout and fruits array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                fruits);

        // Attach adapter to ListView
        listView.setAdapter(adapter);
    }
}
