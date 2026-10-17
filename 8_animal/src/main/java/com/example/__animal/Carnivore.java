package com.example.__animal;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Carnivore extends Animal{
    private int smer = 0;
    private int smerPohybu = 1;

    public Carnivore(){
        vykresli();
    }

    @Override
    public void posun() {
        Pane p = (Pane) getParent();
        double maxX = p.getWidth()-getWidth()-10;
        double maxY = p.getHeight()-getWidth()-10;
        double minX = 10;
        double minY = 65;

        if (smerPohybu==1){
            if (smer==0){
                setLayoutX(getLayoutX()+3);
                if (getLayoutX()>=maxX) smer=1;
            }
            else if (smer==1){
                setLayoutY(getLayoutY()+3);
                if (getLayoutY()>=maxY) smer=2;
            }
            else if (smer==2){
                setLayoutX(getLayoutX()-3);
                if (getLayoutX()<=minX) smer=3;
            }
            else if (smer==3){
                setLayoutY(getLayoutY()-3);
                if (getLayoutY()<=minY) smer=0;
            }
        }
        else {
            if (smer==0){
                setLayoutX(getLayoutX()-3);
                if (getLayoutX()<=minX) smer=3;
            }
            else if (smer==3){
                setLayoutY(getLayoutY()+3);
                if (getLayoutY()>=maxY) smer=2;
            }
            else if (smer==2){
                setLayoutX(getLayoutX()+3);
                if (getLayoutX()>=maxX) smer=1;
            }
            else if (smer==1){
                setLayoutY(getLayoutY()-3);
                if (getLayoutY()<=minY) smer=0;
            }
        }
    }

    public void zmenSmer(){
        smerPohybu = -smerPohybu;
    }

    public void nastavSmer(int smer){
        this.smer = smer;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.RED);
        gc.fillOval(0,0,40,40);

        gc.setFill(Color.BLACK);
        gc.fillOval(10,11,6,6);
        gc.fillOval(24,11,6,6);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.strokeLine(13,23,16,20);
        gc.strokeLine(16,20,24,20);
        gc.strokeLine(24,20,27,23);

        gc.strokeLine(13,23,16,28);
        gc.strokeLine(16,28,24,28);
        gc.strokeLine(24,28,27,23);

        gc.strokeLine(18,20,18,28);
        gc.strokeLine(22,20,22,28);
        gc.strokeLine(13,24,27,24);
    }
}