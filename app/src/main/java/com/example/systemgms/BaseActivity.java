package com.example.systemgms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.systemgms.db.DBHelper;
import com.example.systemgms.db.Session;

public class BaseActivity extends AppCompatActivity {
    DBHelper myDb;
    Session session;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         myDb= new DBHelper(this);
         session=new Session(this);
    }
}
