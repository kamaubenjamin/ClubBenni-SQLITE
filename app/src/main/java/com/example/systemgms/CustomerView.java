package com.example.systemgms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.systemgms.db.DBHelper;

public class CustomerView extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        DBHelper myDb = new DBHelper(this);
        Intent in = new Intent(this, ViewBookings.class);
        Intent in2 = new Intent(this, EventActivity.class);

        Button button = (Button) findViewById(R.id.viewbookings);
        Button button2 = (Button) findViewById(R.id.viewevents);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomerView.this, "Lets View", Toast.LENGTH_SHORT).show();
                startActivity(in);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CustomerView.this, "Lets View the Events Available", Toast.LENGTH_SHORT).show();
                    startActivity(in2);
                }




        });
    }
}

