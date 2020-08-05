package com.github.bazukaa.nakshatra.portfolio.db.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.bazukaa.nakshatra.portfolio.db.dao.UserDao;
import com.github.bazukaa.nakshatra.portfolio.models.Project;
import com.github.bazukaa.nakshatra.portfolio.models.Timeline;
import com.github.bazukaa.nakshatra.portfolio.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase userDatabaseInstance;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context){
        if(userDatabaseInstance == null){
            userDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabaseInstance;
    }
}
