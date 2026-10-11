package com.example.ball;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Ball extends Canvas{
    private GraphicsContext gc;
    private double dx = 3;
    private double dy = 2;
    private boolean zastavene = false;
    private Timeline t;

    public Ball(){
        super(60,60);
        setLayoutX(50);
        setLayoutY(50);
        this.gc = this.getGraphicsContext2D();
        vykresli();
        t = new Timeline(new KeyFrame(Duration.millis(20),e -> posun()));
        t.setCycleCount(Timeline.INDEFINITE);
        setOnMousePressed(e -> zastav());
        setOnKeyPressed(e -> spracuj(e));
        setFocusTraversable(true);
    }

    public void start(){
        t.play();
        requestFocus();
    }

    private void zastav(){
        if(zastavene){
            t.play();
            zastavene = false;
        }
        else {
            t.stop();
            zastavene = true;
        }
        requestFocus();
    }

    private void posun(){
        double sirka = getParent().getLayoutBounds().getWidth();
        double vyska = getParent().getLayoutBounds().getHeight();
        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);
        if(getLayoutX() <= 0){
            setLayoutX(0);
            dx = -dx;
        }
        if(getLayoutX() + getWidth() >= sirka){
            setLayoutX(sirka - getWidth());
            dx = -dx;
        }
        if(getLayoutY() <= 0){
            setLayoutY(0);
            dy = -dy;
        }
        if(getLayoutY() + getHeight() >= vyska){
            setLayoutY(vyska - getHeight());
            dy = -dy;
        }
    }

    private void spracuj(KeyEvent e){
        switch (e.getCode()){
            case F: dx *= 1.2; dy *= 1.2; break;
            case S: dx /= 1.2; dy /= 1.2; break;
        }
    }

    private void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLUE);
        gc.fillOval(0,0,60,60);
    }
};