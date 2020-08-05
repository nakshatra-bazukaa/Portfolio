package com.github.bazukaa.nakshatra.portfolio.db.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.github.bazukaa.nakshatra.portfolio.db.dao.TimelineDao;
import com.github.bazukaa.nakshatra.portfolio.models.Timeline;

@Database(entities = {Timeline.class}, version = 1)
public abstract class TimelineDatabase extends RoomDatabase {

    private static TimelineDatabase timelineDatabaseInstance;

    public abstract TimelineDao timelineDao();

    public static synchronized TimelineDatabase getInstance(Context context){
        if(timelineDatabaseInstance == null){
            timelineDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    TimelineDatabase.class, "timeline_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return timelineDatabaseInstance;
    }
}
