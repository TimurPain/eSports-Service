package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }
    public void openAchievements(View view){
        Intent intent = new Intent(this, Achievements.class);
        startActivity(intent);
    }
    public void openAboutUs(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
    public void openContacts(View view){
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }
}