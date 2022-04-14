package com.example.mpeiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);

        TextView tv_date_event = findViewById(R.id.tv_date_event);
        tv_date_event.setText(getIntent().getStringExtra("event_date"));
    }
}