package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
    public void openMain(View view){
        Intent intent = new Intent(this, MainActivity2.class);
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