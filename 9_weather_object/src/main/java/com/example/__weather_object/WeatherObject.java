package com.example.__weather_object;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;


public abstract class WeatherObject extends Canvas {
    protected GraphicsContext gc;
    protected Timeline t;

    public WeatherObject(){
        super(60,40);
        this.gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(50), e -> posun()));
        t.setCycleCount(Timeline.INDEFINITE);
        setFocusTraversable(true);
        t.play();
    }

    public void posundolava(){
        setLayoutX(getLayoutX()-20);
    }

    public abstract void posun();
    public abstract void vykresli();
}