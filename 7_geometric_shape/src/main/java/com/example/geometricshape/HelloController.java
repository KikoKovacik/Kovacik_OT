package com.example.geometricshape;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HelloController {
    @FXML private Pane root;
    private Random nahoda = new Random();
    @FXML protected void rectangle(){
        MyRectangle obdlznik = new MyRectangle();
        obdlznik.setLayoutX(nahoda.nextDouble()*(root.getWidth()-20));
        obdlznik.setLayoutY(60+nahoda.nextDouble()*(root.getHeight()-160));
        root.getChildren().add(obdlznik);}
    @FXML protected void circle(){
        MyCircle kruh = new MyCircle();
        kruh.setLayoutX(20+nahoda.nextDouble()*(root.getWidth()-40));
        kruh.setLayoutY(60+nahoda.nextDouble()*(root.getHeight()-140));
        root.getChildren().add(kruh);}
    @FXML protected void square(){
        MySquare stvorec = new MySquare();
        stvorec.setLayoutX(nahoda.nextDouble()*(root.getWidth()-110));
        stvorec.setLayoutY(60+nahoda.nextDouble()*(root.getHeight()-90));
        root.getChildren().add(stvorec);
    }
    @FXML protected void blue(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof MyCircle) ((MyCircle)my).zmenafarby();
        }
    }
    @FXML protected void down(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof GeometricShape) ((GeometricShape)my).posundole();
        }}
}
