package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<workoutModel> workouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.workout_list);

        setUpWorkouts();

        workoutAdapter adapter = new workoutAdapter(this, workouts,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpWorkouts(){
        workouts.add(new workoutModel("Chest & Triceps","beginner",R.drawable.pushups));
        workouts.add(new workoutModel("Back & Biceps","beginner",R.drawable.arms));
        workouts.add(new workoutModel("ABS & Fat Burning","intermediate",R.drawable.fitnes));
        workouts.add(new workoutModel("Shoulders","intermediate",R.drawable.strength));
        workouts.add(new workoutModel("Legs","intermediate",R.drawable.legs));
        workouts.add(new workoutModel("ABS","beginner",R.drawable.abs));
        workouts.add(new workoutModel("Whole Body","Advanced",R.drawable.workout));
        workouts.add(new workoutModel("WarmUp","beginner",R.drawable.warmup));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,TimerActivity.class);
        intent.putExtra("name",workouts.get(position).getName());
        startActivity(intent);
    }
}