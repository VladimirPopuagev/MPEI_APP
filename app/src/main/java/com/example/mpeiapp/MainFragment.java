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
import com.example.mpeiapp.Adapters.OlympiadAdapter;
import com.example.mpeiapp.Database.DBdelegate;
import com.example.mpeiapp.Database.DatabaseAsyncLoader;
import com.example.mpeiapp.Database.DatabaseDao;
import com.example.mpeiapp.model.Category;
import com.example.mpeiapp.model.Event;
import com.example.mpeiapp.model.Olympiad;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView categoryRecycler, eventRecycler, olympiadRecycler;
    CategoryAdapter categoryAdapter;
    EventAdapter eventAdapter;
    OlympiadAdapter olympiadAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        DatabaseDao databaseDao = ((DBdelegate) getContext().getApplicationContext()).getDatabase().getDatabaseDao();
        initialization(v);

        // Добавление списков в бд
        databaseDao.insertEvents(getListEvent());
        databaseDao.insertOlympiads(getListOlympiad());

        // Извлечение из бд списков
        List<Event> postToAdapterEventList = databaseDao.getEvents();
        List<Olympiad> postToAdapterOlympiadList = databaseDao.getOlympiads();
        setEventAdapter(postToAdapterEventList);
        setOlympiadAdapter(postToAdapterOlympiadList);


        return v;
    }

    private void initialization(View v) {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Студенческие"));
        categoryList.add(new Category(2, "Школьные"));

        eventRecycler = v.findViewById(R.id.event_recycler);
        categoryRecycler = v.findViewById(R.id.category_recycler);
        olympiadRecycler = v.findViewById(R.id.olympiad_recycler);
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

        categoryAdapter = new CategoryAdapter(getContext(), categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setOlympiadAdapter(List<Olympiad> olympiadList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        olympiadRecycler.setLayoutManager(layoutManager);

        olympiadAdapter = new OlympiadAdapter(getContext(), olympiadList);
        olympiadRecycler.setAdapter(olympiadAdapter);
    }

    private List<Event> getListEvent() {
        List<Event> newDataEvent = new ArrayList<>();
        newDataEvent.add(new Event(1, "Очный день открытых дверей", "10 апреля 2022 года пройдет день открытых дверей в очном формате (в случае, если позволит эпидемиологическая обстановка)."
                , "10 апреля", 1, "https://vk.com/video-31496847_456239129"));
        newDataEvent.add(new Event(2, "Очный день открытых дверей", "15 мая 2022 года пройдет день открытых дверей в очном формате (в случае, если позволит эпидемиологическая обстановка)."
                , "15 мая", 0, null));

        return newDataEvent;
    }

    private List<Olympiad> getListOlympiad() {
        // Создание списка мероприятий:
        List<Olympiad> newOlympiads = new ArrayList<>();
        newOlympiads.add(new Olympiad(1, "Открытая студенческая олимпиада \"Надежда энергетики\"",
                "https://pk.mpei.ru/img/content/logo_ehope.gif", "http://www.energy-olymp.ru/"));
        newOlympiads.add(new Olympiad(2, "Международный инженерный чемпионат (CASE-IN)",
                "https://case-in.ru/img/logo2018.png", "https://case-in.ru/"));
        newOlympiads.add(new Olympiad(3, "Студенческая олимпиада \"Я - профессионал\"",
                "https://edu.sfu-kras.ru/sites/edu.sfu-kras.ru/files/Ya_profi_logos-03.jpg", "https://yandex.ru/profi/"));
        newOlympiads.add(new Olympiad(4, "Олимпиада школьников \"Надежда энергетики\"",
                "https://pk.mpei.ru/img/content/logo_ehope.gif", "https://www.energy-hope.ru/"));
        newOlympiads.add(new Olympiad(5, "Всероссийский форум \"Шаг в будущее\"",
                "https://pk.mpei.ru/img/content/logo_SvB.png", "https://pk.mpei.ru/pod/step_into_the_future.html"));
        newOlympiads.add(new Olympiad(6, "Объединённая межвузовская математическая олимпиада школьников",
                "https://pk.mpei.ru/img/content/logo_ommo.png", "https://pk.mpei.ru/Olympic_games/ommo.html"));
        newOlympiads.add(new Olympiad(7, "Интернет-олимпиада школьников по физике",
                "https://pk.mpei.ru/img/content/logo_int-olymp-phys.jpg", "http://distolymp2.spbu.ru/olymp/"));
        newOlympiads.add(new Olympiad(8, "Университетская олимпиада школьников \"Бельчонок\"",
                "https://pk.mpei.ru/img/content/logo_belchonok.jpg", "https://pk.mpei.ru/Olympic_games/squirrel.html"));

        return newOlympiads;
    }
}

//Для локальной базы данных следующее содержание:
//        List<Event> newDataEvent = new ArrayList<>();
//        newDataEvent.add(new Event(1,"Очный день открытых дверей", "10 апреля 2022 года пройдет день открытых дверей в очном формате (в случае, если позволит эпидемиологическая обстановка)."
//                            , "10 апреля", 1,"https://vk.com/video-31496847_456239129"));
//        newDataEvent.add(new Event(2,"Очный день открытых дверей", "15 мая 2022 года пройдет день открытых дверей в очном формате (в случае, если позволит эпидемиологическая обстановка)."
//                , "15 мая", 0,null));
//
//        databaseDao.insertEvents(newDataEvent);