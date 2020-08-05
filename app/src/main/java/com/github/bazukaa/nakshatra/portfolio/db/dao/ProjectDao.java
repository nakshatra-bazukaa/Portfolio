package com.github.bazukaa.nakshatra.portfolio.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.github.bazukaa.nakshatra.portfolio.models.Project;
import com.github.bazukaa.nakshatra.portfolio.models.User;

import java.util.List;

@Dao
public interface ProjectDao {

    @Insert
    void insert(Project project);

    @Delete
    void delete(Project project);

    @Update
    void update(Project project);

    @Query("SELECT * FROM project_table ORDER BY id DESC")
    LiveData<List<Project>> getProjects();
}
