package com.example.systemgms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.systemgms.db.DBHelper;
import com.example.systemgms.db.Session;

public class EventDetailsActivity  extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);
        DBHelper myDb= new DBHelper(this);
        Session session=new Session(this);
        //Get Details From Bundle passed From MyListAdapter
        TextView title = (TextView)findViewById(R.id.textView2);

        String eventName = getIntent().getExtras().getString("eventName","");
        title.setText(eventName);
        //optional
        //int imageName = getIntent().getExtras().getInt("imageName");


    }
}