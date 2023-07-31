package com.example.workout;

import java.io.Serializable;

public class exerciseModel implements Serializable {
    private String name;
    private String time;

    public exerciseModel(String name, String time){
        this.name = name;
        this.time = time;
    }
    public String getName(){
        return this.name;
    }
    public String getTime(){
        return this.time;
    }
}
