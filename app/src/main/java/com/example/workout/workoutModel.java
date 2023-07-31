package com.example.workout;

import java.util.ArrayList;

public class workoutModel {
    private String name;
    private String typeOfExercise;
    private int image;

    private ArrayList<exerciseModel> exercices = new ArrayList<>();

    public workoutModel(String name,String typeOfExercise,int image,ArrayList<exerciseModel> exercices){
        this.name = name;
        this.typeOfExercise = typeOfExercise;
        this.image = image;
        this.exercices = exercices;
    }
    public String getTypeOfExercise(){
        return this.typeOfExercise;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<exerciseModel> getExercices(){
        return this.exercices;
    }
    public int getImage(){
        return this.image;
    }
}
