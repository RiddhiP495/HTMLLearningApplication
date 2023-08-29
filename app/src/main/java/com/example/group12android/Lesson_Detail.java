package com.example.group12android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.group12android.databinding.ActivityLessonDetailBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Lesson_Detail extends AppCompatActivity implements Serializable {
    public String getString;
    public static final String SHARED_PREF = "shared";
    public static final String TEXT = "text";

    private ActivityLessonDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();

        if (intent == null) {
            Log.d("ABC", "The intent is null");
        } else {
            Lecture lecFromPrev = (Lecture) intent.getSerializableExtra("EXTRA_lecture");
            binding.titleTextView.setText(lecFromPrev.title + "\nLength: " + lecFromPrev.length);
            binding.videoWatchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lecFromPrev.url));
                    startActivity(intent);
                }
            });
            binding.descriptionTextView.setText(lecFromPrev.description);
            binding.markCompleteButton.setActivated(lecFromPrev.isComplete);

            binding.markCompleteButton.setOnClickListener(new View.OnClickListener() {
               // private List<Boolean> isDone = new ArrayList<>();
                @Override
                public void onClick(View view) {

                    //lecFromPrev.isComplete = true;
                    Intent intent = new Intent(Lesson_Detail.this, LectureList.class);

                    startActivity(intent);
                }
            });
            binding.saveNotesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getString = binding.notesSave.getText().toString();
                    binding.notesView.setText(getString);

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(TEXT, binding.notesView.getText().toString());
                    editor.apply();
                }
            });
            update();
        }
    }
    private void update() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT, "");
        binding.notesView.setText(text);
    }
}