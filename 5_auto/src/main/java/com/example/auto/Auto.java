package com.example.auto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas{
    private GraphicsContext gc;
    private boolean automatika = false;
    private boolean zastavene = false;
    private int smer = 1;
    private Timeline t;

    public Auto(){
        super(80,60);
        setLayoutX(20);
        setLayoutY(180);
        this.gc = this.getGraphicsContext2D();
        vykresli();
        t = new Timeline(new KeyFrame(Duration.millis(20),e -> posun()));
        t.setCycleCount(Timeline.INDEFINITE);
        setOnMousePressed(e -> zastav());
        setOnKeyPressed(e -> spracuj(e));
        setFocusTraversable(true);
    }

    public void manual(){
        automatika = false;
        zastavene = false;
        t.stop();
        requestFocus();
    }

    public void automatika(){
        automatika = true;
        zastavene = false;
        t.play();
    }

    private void zastav(){
        if(!automatika) return;
        if(zastavene){
            t.play();
            zastavene = false;
        }
        else {
            t.stop();
            zastavene = true;
        }
    }

    private void posun(){
        double sirka = getParent().getLayoutBounds().getWidth();
        setLayoutX(getLayoutX() + 3*smer);
        if(getLayoutX() + getWidth() >= sirka){
            setLayoutX(sirka - getWidth());
            smer = -1;
        }
        if(getLayoutX() <= 0){
            setLayoutX(0);
            smer = 1;
        }
    }

    private void spracuj(KeyEvent e){
        if(automatika) return;
        switch (e.getCode()){
            case UP: setLayoutY(getLayoutY() - 10); break;
            case DOWN: setLayoutY(getLayoutY() + 10); break;
            case LEFT: setLayoutX(getLayoutX() - 10); break;
            case RIGHT: setLayoutX(getLayoutX() + 10); break;
        }
    }

    private void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,80,40);
        gc.setFill(Color.BLACK);
        gc.fillOval(5,35,20,20);
        gc.setFill(Color.BLACK);
        gc.fillOval(55,35,20,20);
    }
}