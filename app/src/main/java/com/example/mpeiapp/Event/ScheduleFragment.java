package com.example.mpeiapp.Event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mpeiapp.Adapters.SpinnerFormatAdapter;
import com.example.mpeiapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleFragment extends Fragment {

    private Spinner spinnerFormat;
    private SpinnerFormatAdapter spinnerFormatAdapter;

    private ImageButton btnBackToRegistr;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule_layout, container, false);

        initializationSpinner(v);
        initializationButton(v);

        return v;
    }

    private void initializationSpinner(View v) {
        spinnerFormat = v.findViewById(R.id.spinner_format);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), getArrayFormat(), R.layout.spinner_format_item,
                new String[]{"title"}, new int[]{R.id.text_format});

        spinnerFormat.setAdapter(simpleAdapter);
        spinnerFormat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int itemPosition, long l) {
                if (itemPosition == 0) {
                    OfflineScheduleFragment offlineFragment = new OfflineScheduleFragment();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.schedule_container, offlineFragment)
                            .commit();
                }
                else {
                    OnlineScheduleFragment onlineFragment = new OnlineScheduleFragment();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.schedule_container, onlineFragment)
                            .commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private ArrayList<HashMap<String, String>> getArrayFormat() {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("title", "Очное посещение");
        map.put("descrip", "Когда смотришь в экран");
        arrayList.add(map);

        map = new HashMap<>();
        map.put("title", "Онлайн-формат");
        map.put("descrip", "Когда приходишь лично");
        arrayList.add(map);

        return arrayList;
    }

    private void initializationButton(View v) {
        btnBackToRegistr = v.findViewById(R.id.btn_schedule_back_to_registr);
        btnBackToRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                EventFragment eventFragment = new EventFragment();

                // remove from stack EventFragment because we return to it
                fragmentManager.popBackStack(InfoEventFragment.class.getSimpleName(),
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);

                fragmentManager.beginTransaction()
                        .remove(ScheduleFragment.this)
                        .commit();
            }
        });
    }
}
