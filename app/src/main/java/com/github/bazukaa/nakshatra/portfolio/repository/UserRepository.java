package com.github.bazukaa.nakshatra.portfolio.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.github.bazukaa.nakshatra.portfolio.db.dao.ProjectDao;
import com.github.bazukaa.nakshatra.portfolio.db.dao.TimelineDao;
import com.github.bazukaa.nakshatra.portfolio.db.dao.UserDao;
import com.github.bazukaa.nakshatra.portfolio.db.database.ProjectDatabase;
import com.github.bazukaa.nakshatra.portfolio.db.database.TimelineDatabase;
import com.github.bazukaa.nakshatra.portfolio.db.database.UserDatabase;
import com.github.bazukaa.nakshatra.portfolio.models.Project;
import com.github.bazukaa.nakshatra.portfolio.models.Timeline;
import com.github.bazukaa.nakshatra.portfolio.models.User;
import com.github.bazukaa.nakshatra.portfolio.repository.util.ProjectAsyncTask;
import com.github.bazukaa.nakshatra.portfolio.repository.util.TimelineAsyncTask;
import com.github.bazukaa.nakshatra.portfolio.repository.util.UserAsyncTask;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> users;

    private TimelineDao timelineDao;
    private LiveData<List<Timeline>> timelines;

    private ProjectDao projectDao;
    private LiveData<List<Project>> projects;

    public UserRepository(Application application){
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        userDao = userDatabase.userDao();
        users = userDao.getUsers();

        TimelineDatabase timelineDatabase = TimelineDatabase.getInstance(application);
        timelineDao = timelineDatabase.timelineDao();
        timelines = timelineDao.getTimelines();

        ProjectDatabase projectDatabase = ProjectDatabase.getInstance(application);
        projectDao = projectDatabase.projectDao();
        projects = projectDao.getProjects();
    }

    public void insert(User user) { new UserAsyncTask(userDao, UserAsyncTask.INSERT_USER_REQUEST).execute(user); }
    public void update(User user) { new UserAsyncTask(userDao, UserAsyncTask.UPDATE_USER_REQUEST).execute(user); }
    public void delete(User user) { new UserAsyncTask(userDao, UserAsyncTask.DELETE_USER_REQUEST).execute(user); }
    public LiveData<List<User>> getUsers() { return users; }

    public void insert(Timeline timeline) { new TimelineAsyncTask(timelineDao, TimelineAsyncTask.INSERT_TIMELINE_REQUEST).execute(timeline); }
    public void update(Timeline timeline) { new TimelineAsyncTask(timelineDao, TimelineAsyncTask.UPDATE_TIMELINE_REQUEST).execute(timeline); }
    public void delete(Timeline timeline) { new TimelineAsyncTask(timelineDao, TimelineAsyncTask.DELETE_TIMELINE_REQUEST).execute(timeline); }
    public LiveData<List<Timeline>> getTimelines() { return timelines; }

    public void insert(Project project) { new ProjectAsyncTask(projectDao, ProjectAsyncTask.INSERT_PROJECT_REQUEST).execute(project); }
    public void update(Project project) { new ProjectAsyncTask(projectDao, ProjectAsyncTask.UPDATE_PROJECT_REQUEST).execute(project); }
    public void delete(Project project) { new ProjectAsyncTask(projectDao, ProjectAsyncTask.DELETE_PROJECT_REQUEST).execute(project); }
    public LiveData<List<Project>> getProjects() { return projects; }


}
