package com.example.systemgms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.systemgms.db.DBHelper;

public class ClassicMonday extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classicmonday);

        DBHelper myDb = new DBHelper(this);
        Intent in = new Intent(this,ViewBookings.class);

        Button book= findViewById(R.id.button3);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.insertBooking("","2","Classic Monday");
                startActivity(in);
            }
        });

    }
}
