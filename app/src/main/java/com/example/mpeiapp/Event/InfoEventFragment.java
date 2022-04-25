package com.example.mpeiapp.Event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mpeiapp.R;

import org.w3c.dom.Text;

public class InfoEventFragment extends Fragment {

    ImageButton btnBackToRegistr;
    TextView tvSchedule;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_event_layout, container, false);
        btnBackToRegistr = v.findViewById(R.id.btn_back_to_registr);

        btnBackToRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventFragment eventFragment = new EventFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                // remove from stack EventFragment because we return to it
                fragmentManager.popBackStack(EventFragment.class.getSimpleName(),
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);

                fragmentManager.beginTransaction().remove(InfoEventFragment.this).commit();
            }
            });

        tvSchedule = v.findViewById(R.id.tv_schedule);

        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScheduleFragment scheduleFragment = new ScheduleFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.event_container_fragment, scheduleFragment)
                        .addToBackStack(InfoEventFragment.class.getSimpleName())
                        .commit();
            }
        });

        return v;
    }
}
