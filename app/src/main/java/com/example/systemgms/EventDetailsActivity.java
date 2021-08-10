package com.example.systemgms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity  extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);
        //Get Details From Bundle passed From MyListAdapter
        TextView title = (TextView)findViewById(R.id.tvTitle);
        String eventName = getIntent().getExtras().getString("eventName","");
        title.setText(eventName);
        //optional
        //int imageName = getIntent().getExtras().getInt("imageName");
    }
}