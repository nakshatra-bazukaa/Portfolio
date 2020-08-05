package com.github.bazukaa.nakshatra.portfolio.ui.main.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.github.bazukaa.nakshatra.portfolio.ui.main.about.AboutFragment;
import com.github.bazukaa.nakshatra.portfolio.ui.main.github.GithubFragment;
import com.github.bazukaa.nakshatra.portfolio.ui.main.mytimeline.TimelineFragment;
import com.github.bazukaa.nakshatra.portfolio.ui.main.projects.ProjectsFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:
                return new TimelineFragment();
            case 2:
                return new ProjectsFragment();
//            case 3:
//                return new GithubFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
