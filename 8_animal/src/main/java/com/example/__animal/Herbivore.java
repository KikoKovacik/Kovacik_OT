package com.example.__animal;

import javafx.scene.paint.Color;

public class Herbivore extends Animal{
    private int pocitadlo = 0;

    public Herbivore(){
        vykresli();
    }

    @Override
    public void posun() {
        if (pocitadlo<25) setLayoutX(getLayoutX()+2);
        else if (pocitadlo<50) setLayoutY(getLayoutY()+2);
        else if (pocitadlo<75) setLayoutX(getLayoutX()-2);
        else setLayoutY(getLayoutY()-2);
        pocitadlo++;
        if (pocitadlo==100) pocitadlo=0;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GREEN);
        gc.fillOval(0,0,40,40);

        gc.setFill(Color.BLACK);
        gc.fillOval(10,10,6,6);
        gc.fillOval(24,10,6,6);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(16,26,24,26);
        gc.strokeLine(13,23,16,26);
        gc.strokeLine(24,26,27,23);
    }
}