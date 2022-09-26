package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {
    private ArrayList<Coursemodel> courseModalArrayList;
    private Context context;


    public CourseRVAdapter(ArrayList<Coursemodel> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coursemodel modal = courseModalArrayList.get(position);
        holder.NameTV.setText(modal.getCourseName());
        holder.DesignTV.setText(modal.getCourseTracks());
        holder.DepartTV.setText(modal.getCourseDuration());
        holder.IdTV.setText(modal.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, UpdateCourseActivity.class);

                i.putExtra("empName", modal.getCourseName());
                i.putExtra("empDesign", modal.getCourseTracks());
                i.putExtra("empDepart", modal.getCourseDuration());
                i.putExtra("id",modal.getId());
                ((Activity) context).startActivityForResult(i,2);

            }
        });
    }


    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView NameTV, DesignTV, DepartTV, IdTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NameTV = itemView.findViewById(R.id.name);
            DesignTV = itemView.findViewById(R.id.designation);
            DepartTV = itemView.findViewById(R.id.department);
            IdTV = itemView.findViewById(R.id.employeeid);

        }

    }
}
