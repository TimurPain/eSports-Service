package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.esport_service.model.Course;
import com.example.esport_service.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> coursesTitle = new ArrayList<>();
        for(Course c : MainActivity.fullCoursesList){
            if(Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
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