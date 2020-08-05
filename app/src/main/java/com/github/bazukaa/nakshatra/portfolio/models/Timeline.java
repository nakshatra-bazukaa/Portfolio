package com.github.bazukaa.nakshatra.portfolio.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "timeline_table")
public class Timeline {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private String year;
    private String img1;
    private String img2;
    private String img3;
    private String imgDescription1;
    private String imgDescription2;
    private String imgDescription3;

    public Timeline(String title, String description, String year, String img1, String img2, String img3, String imgDescription1, String imgDescription2, String imgDescription3) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.imgDescription1 = imgDescription1;
        this.imgDescription2 = imgDescription2;
        this.imgDescription3 = imgDescription3;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImgDescription1() {
        return imgDescription1;
    }

    public void setImgDescription1(String imgDescription1) {
        this.imgDescription1 = imgDescription1;
    }

    public String getImgDescription2() {
        return imgDescription2;
    }

    public void setImgDescription2(String imgDescription2) {
        this.imgDescription2 = imgDescription2;
    }

    public String getImgDescription3() {
        return imgDescription3;
    }

    public void setImgDescription3(String imgDescription3) {
        this.imgDescription3 = imgDescription3;
    }
}
