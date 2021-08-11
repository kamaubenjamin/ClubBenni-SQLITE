package com.example.systemgms;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemgms.adapter.MyBookingsAdapter;
import com.example.systemgms.db.DBHelper;
import com.example.systemgms.db.Session;
import com.example.systemgms.model.Bookings;

import java.util.ArrayList;

public class ViewBookings  extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbookings);
        DBHelper myDb= new DBHelper(this);
        Session session=new Session(this);
        ArrayList<Bookings> array_list = myDb.getAllBookings();
        Log.d("DBBookings",array_list.toString());
        Boolean isAdmin = true;
        if (session.getString("usertype").equals("2")) {
            isAdmin = false;
         array_list = myDb.getBookingByUser(session.getString("username"));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyBookingsAdapter adapter = new MyBookingsAdapter(array_list,isAdmin);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
