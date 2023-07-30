package com.example.workout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class workoutAdapter extends RecyclerView.Adapter<workoutAdapter.MyViewHolder> {
    Context context;
    ArrayList<workoutModel> workouts;

    public  workoutAdapter(Context context, ArrayList<workoutModel> workouts){
        this.context = context;
        this.workouts = workouts;
    }

    @NonNull
    @Override
    public workoutAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.workout_item_row,parent,false);
        return new workoutAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull workoutAdapter.MyViewHolder holder, int position) {
        holder.name.setText(this.workouts.get(position).getName());
        holder.difficulty.setText(this.workouts.get(position).getTypeOfExercise());
        holder.imageView.setImageResource(this.workouts.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return this.workouts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        TextView difficulty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.cardTitle);
            difficulty = itemView.findViewById(R.id.cardDifficulty);
        }
    }
}
