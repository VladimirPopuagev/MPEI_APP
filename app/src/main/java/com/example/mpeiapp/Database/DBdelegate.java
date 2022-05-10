package com.example.mpeiapp.Database;

import android.app.Application;

import androidx.room.Room;

public class DBdelegate extends Application {
    private DatabaseEvent databaseEvent;

    @Override
    public void onCreate() {
        super.onCreate();

        databaseEvent = Room.databaseBuilder(getApplicationContext(), DatabaseEvent.class, "database_event")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public DatabaseEvent getDatabase() {
        return databaseEvent;
    }
}
