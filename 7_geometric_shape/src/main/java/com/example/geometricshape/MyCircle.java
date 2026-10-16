package com.example.geometricshape;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape{
    private double uhol = 0;

    public MyCircle(){
        vykresli();
    }

    @Override
    public void posun() {
        setLayoutX(getLayoutX()+3*Math.cos(uhol));
        setLayoutY(getLayoutY()+3*Math.sin(uhol));
        uhol += 0.1;
    }

    @Override
    public void vykresli() {
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLACK);
        gc.fillOval(0,0,20,20);
    }

    public void zmenafarby(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLUE);
        gc.fillOval(0,0,20,20);}
}
