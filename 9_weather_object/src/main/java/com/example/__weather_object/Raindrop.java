package com.example.__weather_object;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Raindrop extends WeatherObject{

    public Raindrop(){
        vykresli();
    }

    @Override
    public void posun() {
        setLayoutY(getLayoutY()+5);
        Pane p = (Pane) getParent();
        if (getLayoutY()>p.getHeight()){
            t.stop();
            p.getChildren().remove(this);
        }
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLUE);
        gc.fillOval(0,0,8,14);
    }

    public void zastav(){
        t.stop();
    }
}