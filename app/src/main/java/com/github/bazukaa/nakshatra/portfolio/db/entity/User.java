package com.github.bazukaa.nakshatra.portfolio.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.github.bazukaa.nakshatra.portfolio.ui.main.mytimeline.util.Timeline;
import com.github.bazukaa.nakshatra.portfolio.ui.main.projects.util.Project;

import java.util.List;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String profilePicture;

    private String designation;

    private String philosophy;

    private String emailLink;

    private String githubLink;

    private String linkedinLink;

    private String instagramLink;

    private String facebookLink;

    @TypeConverters(TimelineTypeConverter.class)
    public final List<Timeline> timelines;

    @TypeConverters(ProjectTypeConverters.class)
    public final List<Project> projects;

    public User(int id, String name, String profilePicture, String designation, String philosophy, String emailLink, String githubLink, String linkedinLink, String instagramLink, String facebookLink, List<Timeline> timelines, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
        this.designation = designation;
        this.philosophy = philosophy;
        this.emailLink = emailLink;
        this.githubLink = githubLink;
        this.linkedinLink = linkedinLink;
        this.instagramLink = instagramLink;
        this.facebookLink = facebookLink;
        this.timelines = timelines;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhilosophy() {
        return philosophy;
    }

    public void setPhilosophy(String philosophy) {
        this.philosophy = philosophy;
    }

    public String getEmailLink() {
        return emailLink;
    }

    public void setEmailLink(String emailLink) {
        this.emailLink = emailLink;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
