package com.example.__weather_object;

import javafx.scene.paint.Color;

public class Cloud extends WeatherObject{
    private int pocitadlo = 1;

    public Cloud(){
        vykresli();
    }

    @Override
    public void posun() {
        if (pocitadlo<=100) setLayoutX(getLayoutX()+1);
        else setLayoutX(getLayoutX()-1);
        pocitadlo++;
        if (pocitadlo==201) pocitadlo=1;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GRAY);
        gc.fillOval(0,10,30,25);
        gc.fillOval(15,0,30,30);
        gc.fillOval(30,10,30,25);
    }

    public void zmenafarby(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLUE);
        gc.fillOval(0,10,30,25);
        gc.fillOval(15,0,30,30);
        gc.fillOval(30,10,30,25);}
}