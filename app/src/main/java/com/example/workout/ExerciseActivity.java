package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<exerciseModel> exercices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        TextView text = findViewById(R.id.textView);
        TextView text2 = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView2);
        text.setText(getIntent().getStringExtra("name"));
        text2.setText(getIntent().getStringExtra("difficulty"));
        imageView.setImageResource(getIntent().getIntExtra("image",R.drawable.abs));

        exercices = (ArrayList<exerciseModel>)getIntent().getSerializableExtra("exercices");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        exerciseAdapter adapter = new exerciseAdapter(this, exercices, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,TimerActivity.class);
        intent.putExtra("name",exercices.get(position).getName());
        intent.putExtra("time",exercices.get(position).getTime());
        startActivity(intent);
    }
}