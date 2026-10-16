package com.example.geometricshape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;


public abstract class GeometricShape extends Canvas {
    protected GraphicsContext gc;
    protected Timeline t;

    public GeometricShape(){
        super(20,20);
        this.gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(20), e -> posun()));
        t.setCycleCount(Timeline.INDEFINITE);
        setFocusTraversable(true);
        t.play();
    }

    public void posundole(){
        setLayoutY(getLayoutY()+30);
    }

    public abstract void posun();
    public abstract void vykresli();
}
