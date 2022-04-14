package com.example.mpeiapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpeiapp.EventActivity;
import com.example.mpeiapp.R;
import com.example.mpeiapp.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    Context context;
    List<Event> eventList;

    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eventItem = LayoutInflater.from(context).inflate(R.layout.event_item, parent,false);
        return new EventHolder(eventItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        holder.event_title.setText(eventList.get(position).getTitle());
        holder.event_description.setText(eventList.get(position).getShort_description());
        holder.event_date.setText(eventList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEvent = new Intent(context, EventActivity.class);

                goToEvent.putExtra("eventTitle",eventList.get(position).getTitle());
                goToEvent.putExtra("event_date",eventList.get(position).getDate());

                context.startActivity(goToEvent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static final class EventHolder extends RecyclerView.ViewHolder {

        TextView event_title;
        TextView event_description;
        TextView event_date;

        public EventHolder(@NonNull View itemView) {
            super(itemView);

            event_title = itemView.findViewById(R.id.event_title);
            event_description = itemView.findViewById(R.id.event_description);
            event_date = itemView.findViewById(R.id.event_date);

        }
    }
}
