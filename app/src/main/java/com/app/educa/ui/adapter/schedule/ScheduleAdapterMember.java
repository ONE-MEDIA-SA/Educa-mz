package com.app.educa.ui.adapter.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.educa.R;
import com.app.educa.model.ScheduleUser;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ScheduleAdapterMember extends RecyclerView.Adapter<ScheduleAdapterMember.ViewHolder> {
    ArrayList<ScheduleUser> childArrayList;

    public ScheduleAdapterMember(ArrayList<ScheduleUser> childArrayList) {
        this.childArrayList = childArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(
                parent.getContext())
                .inflate(R.layout.item_user_profile,
                parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.imgUser.getContext())
                .load(childArrayList.get(position).getPhoto())
                .into(holder.imgUser);
    }

    @Override
    public int getItemCount() {

        return childArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView imgUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.schedule_image);
        }
    }

}
