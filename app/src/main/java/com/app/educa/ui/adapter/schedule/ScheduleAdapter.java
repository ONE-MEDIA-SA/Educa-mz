package com.app.educa.ui.adapter.schedule;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.educa.R;
import com.app.educa.model.Schedule;
import com.app.educa.model.ScheduleUser;
import com.app.educa.utils.ScheduleUtils;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Random;


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
        ScheduleUtils utils = new ScheduleUtils();
        int colorPosition = new Random().nextInt(utils.hsvColors.length);

        float arr[] = utils.hsvColors[colorPosition];

        holder.view_left_bar.setBackgroundColor(Color.HSVToColor(arr));
        holder.card_schedule.setCardBackgroundColor(utils.lessBrightColor(arr));
        holder.tv_time.setText(schedule.getStart_time() + " - " + schedule.getEnd_time() +"H");
        holder.tv_title.setText(schedule.getTitle());
        holder.tv_date.setText(schedule.getDate());



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
        View view_left_bar;
        MaterialCardView card_schedule;
        TextView tv_date;
        TextView tv_time;
        TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nested_rv = itemView.findViewById(R.id.rv_users);
            view_left_bar = itemView.findViewById(R.id.view_left_bar);
            card_schedule = itemView.findViewById(R.id.card_schedule);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.schedule_time);
            tv_title = itemView.findViewById(R.id.schedule_title);
        }
    }

}
