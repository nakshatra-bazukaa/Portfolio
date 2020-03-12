package com.github.bazukaa.nakshatra.portfolio.ui.setup.makeEditTimeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.bazukaa.nakshatra.portfolio.R;
import com.github.bazukaa.nakshatra.portfolio.ui.setup.Setup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeEditTimelineActivity extends AppCompatActivity {

    public static final String ADD_REQUEST = "com.github.bazukaa.nakshatra.portfolio.ui.setup.makeEditTimeline.ADD_REQUEST";

    @BindView(R.id.act_mk_edt_tv_timeline)
    TextView typeTitleTv;
    @BindView(R.id.act_mk_edt_et_timeline_end_duration)
    EditText endDuration;
    @BindView(R.id.act_mk_edt_et_timeline_start_duration)
    EditText startDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_edit_timeline);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Preparing to Extract info. from intent
        Intent i = getIntent();

        //Processing the intent
        Integer request = i.getIntExtra(ADD_REQUEST,-1);

        if(request == Setup.ADD_TIMELINE_REQUEST){
            getSupportActionBar().setTitle("Add Timeline");
            typeTitleTv.setText("Timeline");
            startDuration.setHint("2020");
            endDuration.setVisibility(View.INVISIBLE);
        }else{
            getSupportActionBar().setTitle("Add Project");
            typeTitleTv.setText("Project");
        }
    }
}
