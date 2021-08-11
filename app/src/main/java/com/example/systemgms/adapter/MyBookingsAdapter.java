package com.example.systemgms.adapter;

      //  import android.support.v7.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.systemgms.R;
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
                //move data to next Activity
                // bundle stores data to be retrived in the next Activity using Intent
                Bundle bundle = new Bundle();
                bundle.putString("eventName",myListData.getEventName());
//                bundle.putInt("imageName",myListData.getImgIgId());
               // Intent intent = new Intent(view.getContext(), EventDetailsActivity.class);

//                if(myListData.getDescription().contains("ClassicMonday")){
//                    intent = new Intent(view.getContext(), ClassicMonday.class);
//                }
//                if(myListData.getDescription().contains("ThrowBackThursday")){
//                    intent = new Intent(view.getContext(), ThrowbackThursday.class);
//
//                }
//                if(myListData.getDescription().contains("Crazy Friyay")){
//                    intent = new Intent(view.getContext(), CrazyFriday.class);
//
//                }
//
//                intent.putExtras(bundle);
//                view.getContext().startActivity(intent);
                //Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
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
