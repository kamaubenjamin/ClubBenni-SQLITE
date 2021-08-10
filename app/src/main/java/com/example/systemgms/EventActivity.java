package com.example.systemgms;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EventActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

                MyListData[] myListData = new MyListData[]{
                        new MyListData("ClassicMonday", android.R.drawable.ic_dialog_info),
                        new MyListData("ThrowBackThursday", android.R.drawable.ic_dialog_info),
                        new MyListData("Crazy Friyay", android.R.drawable.ic_dialog_info),

                };

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                MyListAdapter adapter = new MyListAdapter(myListData);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            }
        }

