package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    private ImageView clash_royale, csgo, fortnite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        init();

        clash_royale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, ClashRoyaleNewsMain.class);
                intent.putExtra("category", "Clash Royale");
                startActivity(intent);
            }
        });
        csgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CSGONewsMain.class);
                intent.putExtra("category", "CSGO");
                startActivity(intent);
            }
        });
        fortnite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, FortniteNewsMain.class);
                intent.putExtra("category", "Fortnite");
                startActivity(intent);
            }
        });
    }

    private void init(){
        clash_royale = findViewById(R.id.clash_royale);
        csgo = findViewById(R.id.csgo);
        fortnite = findViewById(R.id.fortnite);
    }

}