package com.angie.test0714;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.angie.test0714.ui.timeline.TimelineFragment;

public class Timeline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TimelineFragment.newInstance())
                    .commitNow();
        }
    }



}
