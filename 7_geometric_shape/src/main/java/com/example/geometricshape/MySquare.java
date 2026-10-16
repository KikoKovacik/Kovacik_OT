package com.example.geometricshape;

import javafx.scene.paint.Color;

public class MySquare extends GeometricShape{
    private int pocitadlo = 1;

    public MySquare(){
        vykresli();
    }

    @Override
    public void posun() {
        if (pocitadlo<=20) setLayoutX(getLayoutX()+5);
        else setLayoutX(getLayoutX()-5);
        pocitadlo++;
        if (pocitadlo==41) pocitadlo=1;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,20,20);
    }
}
