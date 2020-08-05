package com.github.bazukaa.nakshatra.portfolio.repository.util;

import android.os.AsyncTask;

import com.github.bazukaa.nakshatra.portfolio.db.dao.ProjectDao;
import com.github.bazukaa.nakshatra.portfolio.models.Project;

public class ProjectAsyncTask extends AsyncTask<Project, Void, Void> {

    public static final int INSERT_PROJECT_REQUEST = 1;
    public static final int UPDATE_PROJECT_REQUEST = 2;
    public static final int DELETE_PROJECT_REQUEST = 3;

    private ProjectDao projectDao;
    private int request;

    public ProjectAsyncTask(ProjectDao projectDao, int request) {
        this.projectDao = projectDao;
        this.request = request;
    }


    @Override
    protected Void doInBackground(Project... projects) {
        if(request == INSERT_PROJECT_REQUEST)
            projectDao.insert(projects[0]);
        else if(request == UPDATE_PROJECT_REQUEST)
            projectDao.update(projects[0]);
        else if(request == DELETE_PROJECT_REQUEST)
            projectDao.delete(projects[0]);

        return null;
    }
}
