package com.example.group12android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;

import com.example.group12android.databinding.LectureLayoutBinding;

import java.util.ArrayList;


public class LectureAdapter extends ArrayAdapter<Lecture> {



    public LectureAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lecture> lectureList) {
        super(context,0,lectureList);
    }

    public LectureAdapter(Context context, ArrayList<Lecture> lectureList) {
        super(context,0,lectureList);
    }

    @Override
    public View getView(int position, @NonNull View convertView,@NonNull ViewGroup parent){
        //setup view binding for lecture layout
      LectureLayoutBinding binding;
      if (convertView == null){
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.lecture_layout,parent,false);
      }

      binding = LectureLayoutBinding.bind(convertView);

      Lecture currLecture = getItem(position);
      binding.tvLessonTitle.setText(currLecture.title);
      binding.tvLessonLength.setText("Length" + currLecture.length);

      //try to attach with button from third screen(details screen)

      if (currLecture.isComplete){
          binding.tvIsComplete.setVisibility(View.VISIBLE);

      }else {
          binding.tvIsComplete.setVisibility(View.GONE);
      }

      return convertView;
  }
}
