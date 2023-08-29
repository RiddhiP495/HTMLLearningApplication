package com.example.group12android;

import java.io.Serializable;
import java.util.ArrayList;

public class LectureListDB {
    public static LectureListDB instance = null;

    public static LectureListDB getInstance(){
        if(instance == null){
            instance = new LectureListDB();
        }
        return instance;
    }
    private LectureListDB(){
        this.lectureList = new ArrayList<Lecture>();

        lectureList.add(new Lecture("1.Introduction to HTML",
                "12 min 16 sec",
                "HTML stands for Hyper Text Markup Language.\n HTML is the standard markup language for creating Web pages.\n HTML describes the structure of a Web page.",
                "https://www.youtube.com/watch?v=bWPMSSsVdPk"));
        lectureList.add(new Lecture("2.Introduction to CSS",
                "6 min 33 sec",
                "CSS is the language we use to style a Web page.\n CSS stands for Cascading Style Sheets.CSS describes how HTML elements are to be displayed on screen, paper, or in other media. \n",
                "https://www.youtube.com/watch?v=qKoajPPWpmo" ));
        lectureList.add(new Lecture("3.HTML Text Formatting and Color",
                "10 min 18 sec",
                "HTML contains several elements for defining text with a special meaning",
                "https://www.youtube.com/watch?v=3YVfF3P0hOc"));
        lectureList.add(new Lecture("4.HTML Attributes",
                "5 min 33 sec",
                "All HTML elements can have attributes. \n Attributes provide additional information about elements. \n Attributes are always specified in the start tag.",
                "https://www.youtube.com/watch?v=jlpkV3oY5-A"));

    }

    private ArrayList<Lecture> lectureList;


    public ArrayList<Lecture> getLectureList(){
        return this.lectureList;
    }
}
