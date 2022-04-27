package com.example.mpeiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactsFragment extends Fragment {

    ImageButton btnTelegram, btnVk, btnWebsite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contacts_main, container, false);

        initialization(v);

        return v;
    }

    private void initialization(View v) {
        btnTelegram = v.findViewById(R.id.btn_telegram_url);
        btnTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRef(Uri.parse("https://t.me/mpeienergy"));
            }
        });

        btnVk = v.findViewById(R.id.btn_vk_url);
        btnVk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRef(Uri.parse("https://vk.com/pkmpeiofficial"));
            }
        });

        btnWebsite = v.findViewById(R.id.btn_site_url);
        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRef(Uri.parse("https://pk.mpei.ru/"));
            }
        });
    }

    private void goToRef(Uri address) {
        Intent goToRefIntent = new Intent(Intent.ACTION_VIEW, address);

        if (goToRefIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(goToRefIntent);
        } else {
            Toast.makeText(getActivity(), "Ссылка не действительна", Toast.LENGTH_SHORT).show();
        }
    }

}
