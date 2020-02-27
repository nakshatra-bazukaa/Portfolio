package com.github.bazukaa.nakshatra.portfolio.ui.main.mytimeline.util;

import com.github.bazukaa.nakshatra.portfolio.ui.main.util.ImageSliderItem;

import java.util.List;

public class Timeline {
    private List<ImageSliderItem> sliderItems;
    private String title;
    private String description;
    private Integer year;

    public Timeline(List<ImageSliderItem> sliderItems, String title, String description, Integer year) {
        this.sliderItems = sliderItems;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public List<ImageSliderItem> getSliderItems() {
        return sliderItems;
    }

    public void setSliderItems(List<ImageSliderItem> sliderItems) {
        this.sliderItems = sliderItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
