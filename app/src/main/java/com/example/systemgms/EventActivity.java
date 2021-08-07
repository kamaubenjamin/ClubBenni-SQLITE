package com.example.systemgms;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_event);

                MyListData[] myListData = new MyListData[] {
                        new MyListData("Email", android.R.drawable.ic_dialog_email),
                        new MyListData("Info", android.R.drawable.ic_dialog_info),
                        new MyListData("Delete", android.R.drawable.ic_delete),
                        new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                        new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                        new MyListData("Map", android.R.drawable.ic_dialog_map),
                        new MyListData("Email", android.R.drawable.ic_dialog_email),
                        new MyListData("Info", android.R.drawable.ic_dialog_info),
                        new MyListData("Delete", android.R.drawable.ic_delete),
                        new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                        new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                        new MyListData("Map", android.R.drawable.ic_dialog_map),
                };

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                MyListAdapter adapter = new MyListAdapter(myListData);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            }
        }

