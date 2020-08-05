package com.github.bazukaa.nakshatra.portfolio.repository.util;

import android.os.AsyncTask;
import com.github.bazukaa.nakshatra.portfolio.db.dao.TimelineDao;
import com.github.bazukaa.nakshatra.portfolio.models.Timeline;

public class TimelineAsyncTask extends AsyncTask<Timeline, Void, Void> {

    public static final int INSERT_TIMELINE_REQUEST = 1;
    public static final int UPDATE_TIMELINE_REQUEST = 2;
    public static final int DELETE_TIMELINE_REQUEST = 3;

    private TimelineDao timelineDao;
    private int request;

    public TimelineAsyncTask(TimelineDao timelineDao, int request) {
        this.timelineDao = timelineDao;
        this.request = request;
    }


    @Override
    protected Void doInBackground(Timeline... timelines) {
        if(request == INSERT_TIMELINE_REQUEST)
            timelineDao.insert(timelines[0]);
        else if(request == UPDATE_TIMELINE_REQUEST)
            timelineDao.update(timelines[0]);
        else if(request == DELETE_TIMELINE_REQUEST)
            timelineDao.delete(timelines[0]);

        return null;
    }
}
