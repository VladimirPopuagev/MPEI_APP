package com.example.mpeiapp.Database;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.mpeiapp.model.Event;

import java.util.List;

public class DatabaseAsyncLoader extends AsyncTaskLoader<List<Event>> {

    public DatabaseAsyncLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Event> loadInBackground() {
        // Здесь обработка базы данных и вытягивание списка мероприятий из неё
        Toast.makeText(getContext(), "ВОТ Я НАЧАЛ РАБОАТТЬ", Toast.LENGTH_LONG).show();
        return null;
    }
}
