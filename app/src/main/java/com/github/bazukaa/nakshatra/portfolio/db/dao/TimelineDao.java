package com.github.bazukaa.nakshatra.portfolio.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.github.bazukaa.nakshatra.portfolio.models.Timeline;
import com.github.bazukaa.nakshatra.portfolio.models.User;

import java.util.List;

@Dao
public interface TimelineDao {
    @Insert
    void insert(Timeline timeline);

    @Delete
    void delete(Timeline timeline);

    @Update
    void update(Timeline timeline);

    @Query("SELECT * FROM timeline_table ORDER BY id DESC")
    LiveData<List<Timeline>> getTimelines();
}
