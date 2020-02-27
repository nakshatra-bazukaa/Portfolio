package com.github.bazukaa.nakshatra.portfolio.ui.main.projects.util;

import com.github.bazukaa.nakshatra.portfolio.ui.main.util.ImageSliderItem;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String title;
    private List<ImageSliderItem> projectImages = new ArrayList<>();
    private String description;
    private String start;
    private String end;

    public Project(String title, List<ImageSliderItem> projectImages, String description, String start, String end) {
        this.title = title;
        this.projectImages = projectImages;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ImageSliderItem> getProjectImages() {
        return projectImages;
    }

    public void setProjectImages(List<ImageSliderItem> projectImages) {
        this.projectImages = projectImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
