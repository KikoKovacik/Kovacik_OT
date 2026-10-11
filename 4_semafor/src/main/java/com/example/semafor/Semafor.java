package com.example.semafor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private GraphicsContext gc;
    private int stav = 0;
    private boolean vypnute = false;
    private boolean automatika = false;
    private boolean svieti = false;
    private Timeline t;
    private Timeline blikanie;

    public Semafor(){
        super(150,400);
        setLayoutX(250);
        this.gc = this.getGraphicsContext2D();
        vykresli(Color.RED, Color.BLACK, Color.BLACK);
        setOnMousePressed(e -> zmenStav());
        t = new Timeline(new KeyFrame(Duration.seconds(1),e -> zmenStav()));
        t.setCycleCount(Timeline.INDEFINITE);
        blikanie = new Timeline(new KeyFrame(Duration.seconds(0.5),e -> blikni()));
        blikanie.setCycleCount(Timeline.INDEFINITE);
    }

    private void blikni(){
        if(svieti){
            vykresli(Color.BLACK, Color.BLACK, Color.BLACK);
            svieti = false;
        }
        else {
            vykresli(Color.BLACK, Color.ORANGE, Color.BLACK);
            svieti = true;
        }
    }

    public void vypni(){
        vypnute = true;
        t.stop();
        blikanie.play();
    }

    public void zapni(){
        vypnute = false;
        blikanie.stop();
        stav = 0;
        vykresli(Color.RED, Color.BLACK, Color.BLACK);
        if(automatika) t.play();
    }

    public void prepni(){
        if(automatika) {
            t.stop();
            automatika = false;
        }
        else {
            t.play();
            automatika = true;
        }
    }

    public void zmenStav(){
        if(vypnute) return;
        if(stav==3) stav = 0;
        else stav++;
        switch (stav){
            case 0: vykresli(Color.RED,Color.BLACK,Color.BLACK); break;
            case 1: vykresli(Color.RED,Color.ORANGE,Color.BLACK); break;
            case 2: vykresli(Color.BLACK,Color.BLACK,Color.GREEN); break;
            case 3: vykresli(Color.BLACK,Color.ORANGE,Color.BLACK); break;
        }
    }

    private void vykresli(Color red, Color yellow, Color green){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GRAY);
        gc.fillRect(0,0,150,400);
        gc.setFill(red);
        gc.fillOval(30,30,80,80);
        gc.setFill(yellow);
        gc.fillOval(30,30+80+10,80,80);
        gc.setFill(green);
        gc.fillOval(30,30+80+10+80+10,80,80);
    }

}