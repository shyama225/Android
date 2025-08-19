package com.example.adapter1;  // Change to your package name

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] posts = {"Post 1", "Post 2", "Post 3", "Post 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);

            listView = findViewById(R.id.list_view);

            ArrayAdapter<String> adapter = null;
            try {
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posts);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Adapter error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (adapter != null) {
                listView.setAdapter(adapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Activity initialization error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
