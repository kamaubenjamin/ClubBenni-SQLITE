package com.example.systemgms.adapter;

      //  import android.support.v7.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.systemgms.R;
import com.example.systemgms.ViewBookings;
import com.example.systemgms.db.DBHelper;
import com.example.systemgms.model.Bookings;

import java.util.ArrayList;


public class MyBookingsAdapter extends RecyclerView.Adapter<MyBookingsAdapter.ViewHolder>{
    private ArrayList<Bookings> listdata;
    Boolean isAdmin;

    // RecyclerView recyclerView;
    public MyBookingsAdapter(ArrayList<Bookings> listdata,Boolean isAdmin) {
        this.listdata = listdata;
        this.isAdmin = isAdmin;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.booking_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Bookings myListData = listdata.get(position);
        holder.textView.setText(myListData.getEventName());
        if (isAdmin){
            holder.tvUsername.setText(myListData.getUsername());
            holder.tvUsername.setVisibility(View.VISIBLE);
        }
//        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Cancel Booking");
                alert.setMessage("Are you sure want to cancel "+myListData.getEventName());
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //update and Delete
                        DBHelper myDbb =new DBHelper(view.getContext());
                        myDbb.updateBookings("2",""+myListData.getBookingId());
                        Intent intent = new Intent(view.getContext(), ViewBookings.class);
                        view.getContext().startActivity(intent);
                    }
                });
                alert.setNegativeButton("No",null);
                alert.show();
              }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView tvUsername;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }


    }
}
