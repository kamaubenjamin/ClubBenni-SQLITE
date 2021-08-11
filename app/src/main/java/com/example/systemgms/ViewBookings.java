package com.example.systemgms;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemgms.adapter.MyBookingsAdapter;
import com.example.systemgms.db.DBHelper;
import com.example.systemgms.model.Bookings;

import java.util.ArrayList;

public class ViewBookings  extends AppCompatActivity {
DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbookings);

        mydb = new DBHelper(this);
//        ArrayList array_list = mydb.getAllCotacts();
//        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
//
//        ListView obj = (ListView) findViewById(R.id.listView1);
//        obj.setAdapter(arrayAdapter);//
        ArrayList<Bookings> array_list = mydb.getAllBookings();
        Log.d("DBBookings",array_list.toString());
//        ListView obj = (ListView) findViewById(R.id.listView1);
//        obj.setAdapter(arrayAdapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyBookingsAdapter adapter = new MyBookingsAdapter(array_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
