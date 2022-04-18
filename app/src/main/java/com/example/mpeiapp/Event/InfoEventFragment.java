package com.example.mpeiapp.Event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mpeiapp.R;

public class InfoEventFragment extends Fragment {

    ImageButton btnBackToRegistr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_event_layout, container, false);
        btnBackToRegistr = v.findViewById(R.id.btn_back_to_registr);
        btnBackToRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: вернуться на прошлый фрагмент
            }
        });

        return v;
    }
}
