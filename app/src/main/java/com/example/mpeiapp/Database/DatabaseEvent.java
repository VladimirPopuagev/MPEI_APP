package com.example.mpeiapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mpeiapp.model.Event;
import com.example.mpeiapp.model.Olympiad;

@Database(entities = {Event.class, Olympiad.class}, version = 2)
public abstract class DatabaseEvent extends RoomDatabase {
public abstract DatabaseDao getDatabaseDao();
}
