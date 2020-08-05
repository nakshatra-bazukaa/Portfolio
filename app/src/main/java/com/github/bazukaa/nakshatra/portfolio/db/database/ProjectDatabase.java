package com.github.bazukaa.nakshatra.portfolio.db.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.github.bazukaa.nakshatra.portfolio.db.dao.ProjectDao;
import com.github.bazukaa.nakshatra.portfolio.models.Project;

@Database(entities = {Project.class}, version = 1)
public abstract class ProjectDatabase extends RoomDatabase {

    private static ProjectDatabase projectDatabaseInstance;

    public abstract ProjectDao projectDao();

    public static synchronized ProjectDatabase getInstance(Context context){
        if(projectDatabaseInstance == null){
            projectDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    ProjectDatabase.class, "project_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return projectDatabaseInstance;
    }
}
