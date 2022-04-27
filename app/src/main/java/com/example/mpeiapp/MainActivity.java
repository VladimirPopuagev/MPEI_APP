package com.example.mpeiapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mpeiapp.Database.DBdelegate;
import com.example.mpeiapp.Database.DatabaseAsyncLoader;
import com.example.mpeiapp.Database.DatabaseDao;
import com.example.mpeiapp.model.Event;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mainSceneText;
    TextView contactsScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();


        if (savedInstanceState == null) {
            Fragment new_fragment =new MainFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, new_fragment)
                    .commit();
        }
    }

    private void initialization() {
        mainSceneText = findViewById(R.id.main_scene);
        contactsScene = findViewById(R.id.contacts);

        mainSceneText.setTextColor(getResources().getColor(R.color.blue_mpei));
        contactsScene.setTextColor(getResources().getColor(R.color.black));

        contactsScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushOnContacts();
            }
        });

        mainSceneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushOnMain();
            }
        });
    }

    private void pushOnMain() {
        mainSceneText.setTextColor(getResources().getColor(R.color.blue_mpei));
        contactsScene.setTextColor(getResources().getColor(R.color.black));

        Fragment new_fragment =new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new_fragment)
                .commit();
    }

    private void pushOnContacts() {
        mainSceneText.setTextColor(getResources().getColor(R.color.black));
        contactsScene.setTextColor(getResources().getColor(R.color.blue_mpei));

        Fragment contactFragment =new ContactsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contactFragment)
                .commit();
    }
}