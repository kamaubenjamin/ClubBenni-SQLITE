package com.example.systemgms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.systemgms.db.DBHelper;

public class CrazyFriday extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crazyfriday);

        DBHelper myDb = new DBHelper(this);
        Intent in = new Intent(this,ViewBookings.class);

        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CrazyFriday.this,"Lets View",Toast.LENGTH_SHORT).show();
                myDb.insertBooking("","2","Crazy Friday");
                startActivity(in);
            }
        });

    }
}
