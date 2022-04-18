package com.example.mpeiapp.Event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mpeiapp.R;

public class EventFragment extends Fragment {

    ImageButton btnInfoEvent;
    ImageButton btnGoToRegistr;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_regist, container,false);

        initialization(v);
        btnInfoEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoEventFragment infoFragment = new InfoEventFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.event_container_fragment, infoFragment)
                        .commit();
            }
        });


        TextView tv_date_event = v.findViewById(R.id.tv_date_event);
        tv_date_event.setText(getArguments().getString("event_date"));

        return v;
    }

    void initialization(View v) {
        btnInfoEvent = v.findViewById(R.id.btn_info_event);
        btnGoToRegistr = v.findViewById(R.id.btn_registr_event);
    }
}
