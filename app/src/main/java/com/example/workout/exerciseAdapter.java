package com.example.workout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class exerciseAdapter extends RecyclerView.Adapter<exerciseAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<exerciseModel> exercises;

    public exerciseAdapter(Context context, ArrayList<exerciseModel> exercises, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.exercises = exercises;
        this.recyclerViewInterface = recyclerViewInterface;

    }
    @NonNull
    @Override
    public exerciseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_item_row,parent,false);
        return new exerciseAdapter.MyViewHolder(view,recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull exerciseAdapter.MyViewHolder holder, int position) {
        holder.exerciseName.setText(this.exercises.get(position).getName());
        holder.exerciseTime.setText(this.exercises.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView exerciseName;
        TextView exerciseTime;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.exerciseName);
            exerciseTime = itemView.findViewById(R.id.timeExercise);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
