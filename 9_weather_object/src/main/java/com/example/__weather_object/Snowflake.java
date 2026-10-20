package com.example.__weather_object;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Snowflake extends WeatherObject{
    private double uhol = 0;

    public Snowflake(){
        vykresli();
    }

    @Override
    public void posun() {
        setLayoutY(getLayoutY()+2);
        setLayoutX(getLayoutX()+Math.sin(uhol));
        uhol += 0.1;
        Pane p = (Pane) getParent();
        if (getLayoutY()>p.getHeight()){
            t.stop();
            p.getChildren().remove(this);
        }
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setStroke(Color.LIGHTBLUE);
        gc.setLineWidth(2);
        gc.strokeLine(10,0,10,20);
        gc.strokeLine(0,10,20,10);
        gc.strokeLine(2,2,18,18);
        gc.strokeLine(18,2,2,18);
    }
}