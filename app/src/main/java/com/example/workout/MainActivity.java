package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

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
        exerciseModel ex1 = new exerciseModel("Push ups","2");
        exerciseModel ex2 = new exerciseModel("Squats","3");
        exerciseModel ex3 = new exerciseModel("Lunges","2");
        exerciseModel ex4 = new exerciseModel("Pull ups","4");
        exerciseModel ex5 = new exerciseModel("Plank","1");
        exerciseModel ex6 = new exerciseModel("Crunches","1");
        exerciseModel ex7 = new exerciseModel("Burpees","3");
        exerciseModel ex8 = new exerciseModel("Deadlifts","4");
        exerciseModel ex9 = new exerciseModel("Bicep curls","2");
        exerciseModel ex10 = new exerciseModel("Tricep dips","3");
        exerciseModel ex11 = new exerciseModel("Calf raises","1");
        exerciseModel ex12 = new exerciseModel("Russian twists","2");
        exerciseModel ex13 = new exerciseModel("Leg press","3");
        exerciseModel ex14 = new exerciseModel("Bench press","4");
        exerciseModel ex15 = new exerciseModel("Shoulder press","3");
        exerciseModel ex16 = new exerciseModel("Barbell rows","4");
        exerciseModel ex17 = new exerciseModel("Dumbbell flyes","2");
        exerciseModel ex18 = new exerciseModel("Hammer curls","2");
        exerciseModel ex19 = new exerciseModel("Arnold press","3");
        exerciseModel ex20 = new exerciseModel("Chin-ups","4");
        exerciseModel ex21 = new exerciseModel("Side lunges","2");
        exerciseModel ex22 = new exerciseModel("Mountain climbers","3");
        exerciseModel ex23 = new exerciseModel("Leg curls","2");
        exerciseModel ex24 = new exerciseModel("Incline bench press","3");
        exerciseModel ex25 = new exerciseModel("Dumbbell pullover","4");
        exerciseModel ex26 = new exerciseModel("Dips","3");
        exerciseModel ex27 = new exerciseModel("Box jumps","4");
        exerciseModel ex28 = new exerciseModel("Reverse crunches","2");
        exerciseModel ex29 = new exerciseModel("Seated calf raises","3");
        exerciseModel ex30 = new exerciseModel("Plank jacks","1");

        ArrayList<exerciseModel> chestTriceps = new ArrayList<>(Arrays.asList(ex1, ex4, ex7, ex8,ex17,ex11));
        ArrayList<exerciseModel> backBiceps = new ArrayList<>(Arrays.asList(ex4, ex8, ex10, ex14,ex12));
        ArrayList<exerciseModel> absFatBurning = new ArrayList<>(Arrays.asList(ex5, ex6,ex18,ex19,ex21));
        ArrayList<exerciseModel> shoulders = new ArrayList<>(Arrays.asList(ex10,ex24,ex22,ex15));
        ArrayList<exerciseModel> legs = new ArrayList<>(Arrays.asList(ex2, ex3, ex9,ex27,ex26,ex23,ex13));
        ArrayList<exerciseModel> abs = new ArrayList<>(Arrays.asList(ex6,ex28,ex16,ex20,ex25));
        ArrayList<exerciseModel> wholeBody = new ArrayList<>(Arrays.asList(ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, ex10));
        ArrayList<exerciseModel> warmUp = new ArrayList<>(Arrays.asList(ex2, ex5,ex29,ex30));

        workouts.add(new workoutModel("Chest & Triceps","beginner",R.drawable.pushups,chestTriceps));
        workouts.add(new workoutModel("Back & Biceps","beginner",R.drawable.arms,backBiceps));
        workouts.add(new workoutModel("ABS & Fat Burning","intermediate",R.drawable.fitnes,absFatBurning));
        workouts.add(new workoutModel("Shoulders","intermediate",R.drawable.strength,shoulders));
        workouts.add(new workoutModel("Legs","intermediate",R.drawable.legs,legs));
        workouts.add(new workoutModel("ABS","beginner",R.drawable.abs,abs));
        workouts.add(new workoutModel("Whole Body","Advanced",R.drawable.workout,wholeBody));
        workouts.add(new workoutModel("WarmUp","beginner",R.drawable.warmup,warmUp));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,ExerciseActivity.class);
        intent.putExtra("name",workouts.get(position).getName());
        intent.putExtra("difficulty",workouts.get(position).getTypeOfExercise());
        intent.putExtra("image",workouts.get(position).getImage());
        intent.putExtra("exercices",workouts.get(position).getExercices());
        startActivity(intent);
    }
}