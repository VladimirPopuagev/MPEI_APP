package com.example.mpeiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiapp.Adapters.CategoryAdapter;
import com.example.mpeiapp.Adapters.EventAdapter;
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

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Дни открытых дверей"));
        categoryList.add(new Category(2,"Олимпиады"));

        categoryRecycler = v.findViewById(R.id.category_recycler);
        setCategoryAdapter(categoryList);

        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event(4,"День IT-технологий", "Приходите посмотреть на наш классный универ.\n\nТут столько колонн, что голова кружится. В главном корпусе всё классно,но в остальных похуже, но тоже классно. Всем советуем!"
                ,"5 апреля"));
        eventList.add(new Event(5,"День программиста", "Ах, какой праздник. Все хотят ими стать.\n\nЭто круче, чем космонавты, так что становись таким же"
                ,"1 апреля"));

        eventRecycler = v.findViewById(R.id.event_recycler);
        setEventAdapter(eventList);


        return v;
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
