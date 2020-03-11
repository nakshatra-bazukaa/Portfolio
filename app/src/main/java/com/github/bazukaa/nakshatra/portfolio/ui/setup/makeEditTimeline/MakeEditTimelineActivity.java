package com.github.bazukaa.nakshatra.portfolio.ui.setup.makeEditTimeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.bazukaa.nakshatra.portfolio.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeEditTimelineActivity extends AppCompatActivity {

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

        Intent i = getIntent();
        String requestType = i.getStringExtra("ADD");
        Integer requestId = i.getIntExtra("ID",-1);

        getSupportActionBar().setTitle(requestType);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(requestId == 1){
            typeTitleTv.setText("Timeline");
            startDuration.setHint("2020");
            endDuration.setVisibility(View.INVISIBLE);
        }else{
            typeTitleTv.setText("Project");
        }
    }
}
