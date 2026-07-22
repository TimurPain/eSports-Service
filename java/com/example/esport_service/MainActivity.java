package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esport_service.adapter.CategoryAdapter;
import com.example.esport_service.adapter.CourseAdapter;
import com.example.esport_service.model.Category;
import com.example.esport_service.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"CR"));
        categoryList.add(new Category(2,"CSGO"));
        categoryList.add(new Category(3,"Fortnite"));
        categoryList.add(new Category(4,"Прочее"));

        //setCategoryRecycler(categoryList);

        courseList.add(new Course(1,"clashroyale1", "Курс по Clash Royale\nдля профессионалов", "1  месяц",
                "Умение играть\nразными колодами", "#AD8D00",
                "1. О курсе\nЭтот курс для профессионалов по игре Clash Royale, поможет вам стать киберспортсменом. В ходе прохождения курса вас будет обучать мастер по этой игре с его багажом знаний. \n\n2. Расписание\nКаждый день буду проходить обучение по несколько часов с гибким графиком для вас.\n\n3. Метод обучения\nУроки будут проходить в онлайн формате на платформе Discord, мастер будет наблюдать за вашей игрой, подсказывать вам и давать советы.\n\n4. Результат\nПосле окончания курса вы сможете играть на равных с киберспортсменами и побеждать или занимать высокие места на турнирах в мире Clash Royale.",
                1, "70000 тенге"));
        courseList.add(new Course(2,"clashroyale2", "Курс по Clash Royale\nдля опытных", "3 недели",
                "Знание механик\nигры", "#394658",
                "1. О курсе\nЭтот курс для опытных по игре Clash Royale, поможет вам улучшить свою игру. В ходе прохождения курса вас будет обучать мастер по этой игре с его багажом знаний. \n\n2. Расписание\nКаждый день буду проходить обучение по несколько часов с гибким графиком для вас.\n\n3. Метод обучения\nУроки будут проходить в онлайн формате на платформе Discord, мастер будет наблюдать за вашей игрой, подсказывать вам и давать советы.\n\n4. Результат\nПосле окончания курса у вас будут несколько колод натренированных на высшим уровне в мире Clash Royale.",
                2, "18000 тенге"));
        courseList.add(new Course(3,"clashroyale3", "Курс по Clash Royale\nдля начинающих", "1 неделя",
                "Каждый может\nкупить", "#0038C3",
                "1. О курсе\nЭтот курс для начинающих по игре Clash Royale, поможет вам лучше изучить игру. В ходе прохождения курса вас будет обучать мастер по этой игре с его багажом знаний. \n\n2. Расписание\nКаждый день буду проходить обучение по несколько часов с гибким графиком для вас.\n\n3. Метод обучения\nУроки будут проходить в онлайн формате на платформе Discord, мастер будет наблюдать за вашей игрой, подсказывать вам и давать советы.\n\n4. Результат\nПосле окончания курса у вас будут базовые знания, которые дадут большой толчек для вас в мире Clash Royale.",
                3, "5000 тенге"));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
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
    public void openNews(View view){
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }


    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    //private void setCategoryRecycler(List<Category> categoryList) {
    //    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
    //    categoryRecycler = findViewById(R.id.categoryRecycler);
    //    categoryRecycler.setLayoutManager(layoutManager);
    //    categoryAdapter = new CategoryAdapter(this, categoryList);
    //    categoryRecycler.setAdapter(categoryAdapter);
    //}
    public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for(Course c : courseList){
            if(c.getCategory() == category){
                filterCourses.add(c);
            }

            courseList.clear();
            courseList.addAll(filterCourses);

            courseAdapter.notifyDataSetChanged();
        }
    }
}