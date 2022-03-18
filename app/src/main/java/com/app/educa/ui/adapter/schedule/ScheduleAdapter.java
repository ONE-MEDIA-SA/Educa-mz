package com.app.educa.ui.adapter.schedule;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.educa.R;
import com.app.educa.model.Schedule;
import com.app.educa.model.ScheduleUser;

import java.util.ArrayList;


public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private Activity activity;
    ArrayList<Schedule> scheduleArrayList;
    ArrayList<ScheduleUser> scheduleUserArrayList;

    public ScheduleAdapter(Activity activity, ArrayList<Schedule> ScheduleArrayList,
                           ArrayList<ScheduleUser> ScheduleUserArrayList) {
        this.activity = activity;
        this.scheduleArrayList = ScheduleArrayList;
        this.scheduleUserArrayList = ScheduleUserArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_schedule,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Schedule schedule = scheduleArrayList.get(position);

        ScheduleAdapterMember adapterMember = new ScheduleAdapterMember(scheduleUserArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        holder.nested_rv.setLayoutManager(linearLayoutManager);
        holder.nested_rv.setAdapter(adapterMember);
    }

    @Override
    public int getItemCount() {
        return scheduleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView nested_rv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nested_rv = itemView.findViewById(R.id.rv_users);
        }
    }

}
