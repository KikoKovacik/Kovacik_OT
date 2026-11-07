package com.example._4_opakovanie1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Mucha extends Hmyz{
    public Mucha(Pane root) {
        super(root);
        setOnMousePressed(e->zanikne());
    }

    public void zastav(){
        t.stop();
    }

    private void zanikne(){
        t.stop(); //TREBA ZASTAVIT CASOVAC, INAK DALEJ BEZI AJ BEZ KRESLENIA (BUDE SA STRHAVAT BOD)!
        root.getChildren().remove(this);
    }

    protected void vykresli(){
        gc.setFill(Color.BLACK);
        gc.fillOval(0,0,getWidth(),getHeight());
    }

    protected void pohyb(){
        setLayoutX(getLayoutX()+(int)(Math.random()*5)-2);
        setLayoutY(getLayoutY()+(int)(Math.random()*5)-2);
    }
}
