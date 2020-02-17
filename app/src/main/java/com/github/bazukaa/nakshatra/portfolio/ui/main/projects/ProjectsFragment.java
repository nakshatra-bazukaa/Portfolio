package com.github.bazukaa.nakshatra.portfolio.ui.main.projects;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.bazukaa.nakshatra.portfolio.R;
import com.github.bazukaa.nakshatra.portfolio.viewmodel.ProjectsViewModel;

public class ProjectsFragment extends Fragment {

    private ProjectsViewModel mViewModel;

    public static ProjectsFragment newInstance() {
        return new ProjectsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.projects_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProjectsViewModel.class);
        // TODO: Use the ViewModel
    }

}