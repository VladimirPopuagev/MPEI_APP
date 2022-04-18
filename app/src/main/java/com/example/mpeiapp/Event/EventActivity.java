package com.example.mpeiapp.Event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mpeiapp.MainFragment;
import com.example.mpeiapp.R;

public class EventActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);

        if (savedInstanceState == null) {
            Fragment eventFragment =new EventFragment();
            eventFragment.setArguments(intentToBundle(getIntent()));
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.event_container_fragment, eventFragment)
                    .commit();
        }
    }

    /*
    * This method send parameters from activity Intent to Arguments fragment
    * */
    private Bundle intentToBundle(Intent intent) {
        Bundle args = new Bundle();
        args.putString("event_date", intent.getStringExtra("event_date"));

        return args;
    }
}