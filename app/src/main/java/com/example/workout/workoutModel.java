package com.example.workout;

public class workoutModel {
    private String name;
    private String typeOfExercise;
    private int image;

    public workoutModel(String name,String typeOfExercise,int image){
        this.name = name;
        this.typeOfExercise = typeOfExercise;
        this.image = image;
    }
    public String getTypeOfExercise(){
        return this.typeOfExercise;
    }
    public String getName(){
        return this.name;
    }
    public int getImage(){
        return this.image;
    }
}
