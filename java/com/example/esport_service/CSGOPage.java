package com.example.esport_service;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CSGOPage extends AppCompatActivity {

    TextView title, description;

    String data3, data4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csgopage);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("csImage") && getIntent().hasExtra("data3") && getIntent().hasExtra("data4")){

            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(data3);
        description.setText(data4);
    }
}