package com.example.mpeiapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mpeiapp.model.Event;

import java.util.List;
@Dao
public interface DatabaseDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertEvents(List<Event> events);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertEvent(Event event);

    //getters
    @Query("SELECT * FROM event")
    List<Event> getEvents();

    @Query("SELECT * FROM event WHERE id = :eventId")
    Event getEventWithId(int eventId);

    //update
    @Update
    int updateEventInfo(Event event);

    //delete
    @Query("DELETE FROM event WHERE id = :eventId")
    int deleteEventById(int eventId);

    @Delete
    int deleteEvent(Event event);

}
