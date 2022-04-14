package com.example.mpeiapp.model;

public class Event {
    /*For open door day*/
    int id;
    String title;
    String short_description;
    String date;

    public Event(int id, String title, String short_description, String date) {
        this.id = id;
        this.title = title;
        this.short_description = short_description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
