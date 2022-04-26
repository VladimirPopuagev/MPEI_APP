package com.example.mpeiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiapp.Adapters.CategoryAdapter;
import com.example.mpeiapp.Adapters.EventAdapter;
import com.example.mpeiapp.Database.DBdelegate;
import com.example.mpeiapp.Database.DatabaseAsyncLoader;
import com.example.mpeiapp.Database.DatabaseDao;
import com.example.mpeiapp.model.Category;
import com.example.mpeiapp.model.Event;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView categoryRecycler, eventRecycler;
    CategoryAdapter categoryAdapter;
    EventAdapter eventAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container,false);

        DatabaseDao databaseDao = ((DBdelegate) getContext().getApplicationContext()).getDatabase().getDatabaseDao();
        initialization(v);

        List<Event> postToAdapterList = databaseDao.getEvents();

        setEventAdapter(postToAdapterList);

        return v;
    }

    private void initialization(View v) {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Дни открытых дверей"));
        categoryList.add(new Category(2,"Олимпиады"));

        eventRecycler = v.findViewById(R.id.event_recycler);
        categoryRecycler = v.findViewById(R.id.category_recycler);
        setCategoryAdapter(categoryList);
    }

    private void setEventAdapter(List<Event> eventList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        eventRecycler.setLayoutManager(layoutManager);

        eventAdapter = new EventAdapter(getContext(), eventList);
        eventRecycler.setAdapter(eventAdapter);
    }

    private void setCategoryAdapter(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(getContext(),categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

}
