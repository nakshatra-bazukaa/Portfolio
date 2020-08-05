package com.github.bazukaa.nakshatra.portfolio.repository.util;

import android.os.AsyncTask;
import com.github.bazukaa.nakshatra.portfolio.db.dao.UserDao;
import com.github.bazukaa.nakshatra.portfolio.models.User;

public class UserAsyncTask extends AsyncTask<User, Void, Void> {
    public static final int INSERT_USER_REQUEST = 1;
    public static final int UPDATE_USER_REQUEST = 2;
    public static final int DELETE_USER_REQUEST = 3;

    private UserDao userDao;
    private int request;

    public UserAsyncTask(UserDao userDao, int request) {
        this.userDao = userDao;
        this.request = request;
    }


    @Override
    protected Void doInBackground(User... users) {
        if(request == INSERT_USER_REQUEST)
            userDao.insert(users[0]);
        else if(request == UPDATE_USER_REQUEST)
            userDao.update(users[0]);
        else if(request == DELETE_USER_REQUEST)
            userDao.delete(users[0]);

        return null;
    }
}
