package com.example.__animal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;


public abstract class Animal extends Canvas {
    protected GraphicsContext gc;
    protected Timeline t;
    protected boolean jeZastaveny = false;

    public Animal(){
        super(40,40);
        this.gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(20), e -> {if (!jeZastaveny) posun();}));
        t.setCycleCount(Timeline.INDEFINITE);
        setFocusTraversable(true);
        t.play();
    }

    public void prepniPauzu(){
        jeZastaveny = !jeZastaveny;
    }

    public abstract void posun();
    public abstract void vykresli();
}