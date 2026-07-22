package com.example.esport_service;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esport_service.adapter.CSGONewsAdapter;

public class CSGONewsMain extends AppCompatActivity {

    RecyclerView recyclerView;
    String categoryName, s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.csgo_news1, R.drawable.csgo_news2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csgonews_main);

        categoryName = getIntent().getExtras().get("category").toString();

        Toast.makeText(this, "Выбрана категория " + categoryName, Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.news_csgo);
        s2 = getResources().getStringArray(R.array.description_csgo);
        s3 = getResources().getStringArray(R.array.news_csgo2);
        s4 = getResources().getStringArray(R.array.description_csgo2);

        CSGONewsAdapter cSGONewsAdapter = new CSGONewsAdapter(this, s1, s2, images, s3, s4);
        recyclerView.setAdapter(cSGONewsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}