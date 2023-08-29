package com.example.group12android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.group12android.databinding.LectureListBinding;

import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Random;

public class LectureList extends AppCompatActivity {
    private LectureListBinding binding;
    private ArrayList<Lecture> lectures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LectureListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();



        LectureAdapter lectureAdapter = new LectureAdapter(this, LectureListDB.getInstance().getLectureList());
        binding.lvLecture.setAdapter(lectureAdapter);
        binding.lvLecture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("ABC", "User Clicked on row # " + i);

                /*Random r = new Random();
                boolean randomValue = r.nextBoolean();
                lectures.add(new Lecture("", randomValue,"true"));
                lectureAdapter.notifyDataSetChanged();*/

                Intent intent = new Intent(getApplicationContext(), Lesson_Detail.class);
                lectures = LectureListDB.getInstance().getLectureList();
                intent.putExtra("EXTRA_lecture", lectures.get(i));
                startActivity(intent);

            }
        });


        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                Intent intent = new Intent(LectureList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        } @Override
protected void onResume(){
    super.onResume();

}}
