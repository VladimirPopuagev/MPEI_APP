package com.example.mpeiapp.Event;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mpeiapp.R;

public class EventFragment extends Fragment {

    ImageButton btnInfoEvent;
    ImageButton btnGoToRegistr;
    ImageButton btnGoToYouTube;
    TextView tvRefVK, tvRefYouTube;
    TextView tv_date_event;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.event_regist, container,false);

        initialization(v);
        setClickListeners();

        return v;
    }

    private void goToRef(Uri address) {
        Intent goToRefIntent = new Intent(Intent.ACTION_VIEW, address);

        if (goToRefIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(goToRefIntent);
        } else {
            Toast.makeText(getActivity(), "Ссылка не действительна", Toast.LENGTH_SHORT).show();
        }
    }

    private void initialization(View v) {
        btnInfoEvent = v.findViewById(R.id.btn_info_event);
        btnGoToRegistr = v.findViewById(R.id.btn_registr_event);
        btnGoToYouTube = v.findViewById(R.id.btn_go_to_youTube);

        tvRefVK = v.findViewById(R.id.vk_ref);
        tvRefYouTube = v.findViewById(R.id.youTube_ref);

        tv_date_event = v.findViewById(R.id.tv_date_event);
        tv_date_event.setText(getArguments().getString("event_date"));

        if (getArguments().getInt("eventIsDone", 0) != 0) {
            btnGoToRegistr.setVisibility(View.GONE);
            btnInfoEvent.setVisibility(View.GONE);
            btnGoToYouTube.setVisibility(View.VISIBLE);
        } else {
            btnGoToRegistr.setVisibility(View.VISIBLE);
            btnGoToYouTube.setVisibility(View.GONE);
        }
    }

    private void setClickListeners() {
        btnInfoEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoEventFragment infoFragment = new InfoEventFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.event_container_fragment, infoFragment)
                        .addToBackStack(EventFragment.class.getSimpleName())
                        .commit();
            }
        });

        tvRefVK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://vk.com/pkmpeiofficial");
                goToRef(uri);
            }
        });

        tvRefYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCHnoFt6cHD2BIRJvR41Mqng");
                goToRef(uri);
            }
        });

        btnGoToYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://vk.com/video-31496847_456239129");
                goToRef(uri);
                //Toast.makeText(getActivity(), "Та самая ссылка на гугл форму", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
