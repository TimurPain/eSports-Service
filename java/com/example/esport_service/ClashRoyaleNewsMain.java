package com.example.esport_service;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esport_service.adapter.ClashRoyaleNewsAdapter;

public class ClashRoyaleNewsMain extends AppCompatActivity {

    RecyclerView recyclerView;
    String categoryName, s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.cr_news1, R.drawable.cr_news2, R.drawable.cr_news3, R.drawable.cr_news4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clash_royale_news_main);

        categoryName = getIntent().getExtras().get("category").toString();

        Toast.makeText(this, "Выбрана категория " + categoryName, Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.news_clash_royale);
        s2 = getResources().getStringArray(R.array.description_clash_royale);
        s3 = getResources().getStringArray(R.array.news_clash_royale2);
        s4 = getResources().getStringArray(R.array.description_clash_royale2);

        ClashRoyaleNewsAdapter clashRoyaleNewsAdapter = new ClashRoyaleNewsAdapter(this, s1, s2, images, s3, s4);
        recyclerView.setAdapter(clashRoyaleNewsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}