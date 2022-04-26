package com.example.mpeiapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mpeiapp.model.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class DatabaseEvent extends RoomDatabase {
public abstract DatabaseDao getDatabaseDao();
}
