package com.github.bazukaa.nakshatra.portfolio.db.entity;

import androidx.room.TypeConverter;

import com.github.bazukaa.nakshatra.portfolio.ui.main.mytimeline.util.Timeline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TimelineTypeConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Timeline> stringToTimelineList(String data){
        if (data == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Timeline>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    private static String timelineListToString(List<Timeline> timelineObjects){
        return gson.toJson(timelineObjects);
    }
}
