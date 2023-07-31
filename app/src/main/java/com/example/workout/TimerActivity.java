package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private int seconds;
    private int totalSeconds;
    private boolean running;
    private boolean wasRunning;
    private TextView time;
    private TextView exerciseName;
    private ImageButton startBtn;
    private ImageButton stopBtn;
    private ImageButton resetBtn;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        setUI();
        totalSeconds = Integer.parseInt(getIntent().getStringExtra("time"))*60;
        exerciseName.setText(getIntent().getStringExtra("name"));
        seconds = totalSeconds;
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        startTimer();
    }
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds",seconds);
        saveInstanceState.putBoolean("running",running);
        saveInstanceState.putBoolean("wasRunning",wasRunning);
    }
    @Override
    protected void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }
    protected void startTimer() {
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String timeStr = String.format("%d:%02d:%02d", hours, minutes, secs);
                time.setText(timeStr);
                if (running && seconds > 0) {
                    seconds--;
                    pb.setProgress(seconds);
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void startTimer(View view){
        running = true;
    }
    public void stopTimer(View view){
        running = false;
    }
    public void resetTimer(View view){
        running = false;
        seconds = totalSeconds;
        pb.setProgress(totalSeconds);
    }

    public void setUI(){
        startBtn = findViewById(R.id.startBtn);
        stopBtn  = findViewById(R.id.stopBtn);
        resetBtn = findViewById(R.id.resetBtn);
        time = findViewById(R.id.time);
        exerciseName = findViewById(R.id.exerciseName);
        pb = findViewById(R.id.progressBar);
        pb.setMax(totalSeconds);
        pb.setProgress(totalSeconds);
    }
}