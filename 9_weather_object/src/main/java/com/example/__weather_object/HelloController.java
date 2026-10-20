package com.example.__weather_object;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HelloController {
    @FXML private Pane root;
    private Random nahoda = new Random();
    @FXML protected void cloud(){
        Cloud oblak = new Cloud();
        oblak.setLayoutX(nahoda.nextDouble()*(root.getWidth()-160));
        oblak.setLayoutY(60);
        root.getChildren().add(oblak);}
    @FXML protected void raindrop(){
        Raindrop kvapka = new Raindrop();
        kvapka.setLayoutX(nahoda.nextDouble()*(root.getWidth()-60));
        kvapka.setLayoutY(60+nahoda.nextDouble()*(root.getHeight()-160));
        root.getChildren().add(kvapka);}
    @FXML protected void snowflake(){
        Snowflake vlocka = new Snowflake();
        vlocka.setLayoutX(20+nahoda.nextDouble()*(root.getWidth()-100));
        vlocka.setLayoutY(60+nahoda.nextDouble()*(root.getHeight()-160));
        root.getChildren().add(vlocka);}
    @FXML protected void stop(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof Raindrop) ((Raindrop)my).zastav();
        }
    }
    @FXML protected void blue(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof Cloud) ((Cloud)my).zmenafarby();
        }
    }
    @FXML protected void left(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof WeatherObject) ((WeatherObject)my).posundolava();
        }}
}