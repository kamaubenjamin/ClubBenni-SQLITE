package com.example.systemgms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CrazyFriday extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crazyfriday);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CrazyFriday.this,"Lets View",Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(getApplicationContext(),CrazyFriday.class);
                startActivity(intent);
            }
        });

    }
}
