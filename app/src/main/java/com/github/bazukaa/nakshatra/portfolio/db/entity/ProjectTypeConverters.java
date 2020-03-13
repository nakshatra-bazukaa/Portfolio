package com.github.bazukaa.nakshatra.portfolio.db.entity;

import androidx.room.TypeConverter;

import com.github.bazukaa.nakshatra.portfolio.ui.main.projects.util.Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ProjectTypeConverters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Project> stringToProjectList(String data){
        if (data == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Project>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    private static String projectListToString(List<Project> projectObjects){
        return gson.toJson(projectObjects);
    }

}
