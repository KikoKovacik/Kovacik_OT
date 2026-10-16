package com.example.geometricshape;

import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape{
    private int pocitadlo = 1;

    public MyRectangle(){
        vykresli();
    }

    @Override
    public void posun() {
        if (pocitadlo<=20) setLayoutY(getLayoutY()+5);
        else setLayoutY(getLayoutY()-5);
        pocitadlo++;
        if (pocitadlo==41) pocitadlo=1;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.RED);
        gc.fillRect(0,0,20,10);
    }
}
