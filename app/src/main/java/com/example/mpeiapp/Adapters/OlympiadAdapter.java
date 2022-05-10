package com.example.mpeiapp.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiapp.R;
import com.example.mpeiapp.model.Olympiad;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class OlympiadAdapter extends RecyclerView.Adapter<OlympiadAdapter.OlympiadHolder> {

    Context context;
    List<Olympiad> olympiads;

    public OlympiadAdapter(Context context, List<Olympiad> olympiads) {
        this.context = context;
        this.olympiads = olympiads;
    }

    @NonNull
    @Override
    public OlympiadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eventItem = LayoutInflater.from(context).inflate(R.layout.olympiad_item, parent,false);
        return new OlympiadAdapter.OlympiadHolder(eventItem);
    }

    @Override
    public void onBindViewHolder(@NonNull OlympiadHolder holder, int position) {
        holder.olympiad_title.setText(olympiads.get(position).getTitle());

        Uri url = Uri.parse(olympiads.get(position).getImg());
        Picasso.get().load(url).into(holder.olympiad_image);

        holder.itemView.setOnClickListener(view -> {
            //Toast.makeText(context, url, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return olympiads.size();
    }

    public static final class OlympiadHolder extends RecyclerView.ViewHolder {
        TextView olympiad_title;
        ImageView olympiad_image;


        public OlympiadHolder(@NonNull View itemView) {
            super(itemView);

            olympiad_title = itemView.findViewById(R.id.olympiad_title);
            olympiad_image = itemView.findViewById(R.id.image_olympiad);
        }
    }
}
