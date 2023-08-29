package com.example.group12android;

import java.io.Serializable;

public class Lecture implements Serializable {
    //properties
   String title;
   String length;
   String description;
   String url;
   String notes;
   boolean isComplete = false;

    //constructors
    public Lecture(String title, String length, String s, String s1, boolean b)
    {
        this.length = length;
        this.title = title;

    }
    public Lecture(String title, String length, String description, String url) {
        this.title = title;
        this.length = length;
        this.description = description;
        this.url = url;
        this.notes = notes;
        this.isComplete = isComplete;

    }



    @Override
    public String toString() {
        return "Lecture{" +
                "title='" + title + '\'' +
                ", length='" + length + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", notes='" + notes + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
