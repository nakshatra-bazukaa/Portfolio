package com.github.bazukaa.nakshatra.portfolio.ui.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.bazukaa.nakshatra.portfolio.R;

public class Setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        getSupportActionBar().setTitle("Setup");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
