package com.example.mpeiapp.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
* This class for description Open Door event
* */

@Entity(tableName = "event")
public class Event {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "short_desc")
    String short_description;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "isDone")
    int isDone;

    @Nullable
    @ColumnInfo(name = "refYouTube")
    String refYouTube;

    public Event() {
    }

    public Event(int id, String title, String short_description, String date, int isDone, @Nullable String refYouTube) {
        this.id = id;
        this.title = title;
        this.short_description = short_description;
        this.date = date;
        this.isDone = isDone;
        this.refYouTube = refYouTube;
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

    public int getIsDone() {
        return isDone;
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    @Nullable
    public String getRefYouTube() {
        return refYouTube;
    }

    public void setRefYouTube(@Nullable String refYouTube) {
        this.refYouTube = refYouTube;
    }
}
