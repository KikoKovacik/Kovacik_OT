package com.example.__animal;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HelloController {
    @FXML private Pane root;
    private Random nahoda = new Random();
    @FXML protected void pridajHerbivore(){
        Herbivore bylozravec = new Herbivore();
        bylozravec.setLayoutX(20+nahoda.nextDouble()*(root.getWidth()-100));
        bylozravec.setLayoutY(70+nahoda.nextDouble()*(root.getHeight()-140));
        root.getChildren().add(bylozravec);}
    @FXML protected void pridajCarnivore(){
        Carnivore masozravec = new Carnivore();
        double maxX = root.getWidth()-50;
        double maxY = root.getHeight()-50;
        int okraj = nahoda.nextInt(4);
        if (okraj==0){
            masozravec.setLayoutX(40+nahoda.nextDouble()*(maxX-70));
            masozravec.setLayoutY(65);
        }
        else if (okraj==1){
            masozravec.setLayoutX(maxX);
            masozravec.setLayoutY(95+nahoda.nextDouble()*(maxY-125));
        }
        else if (okraj==2){
            masozravec.setLayoutX(40+nahoda.nextDouble()*(maxX-70));
            masozravec.setLayoutY(maxY);
        }
        else {
            masozravec.setLayoutX(10);
            masozravec.setLayoutY(95+nahoda.nextDouble()*(maxY-125));
        }
        masozravec.nastavSmer(okraj);
        root.getChildren().add(masozravec);}
    @FXML protected void zmenSmerCarnivore(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof Carnivore) ((Carnivore)my).zmenSmer();
        }
    }
    @FXML protected void prepniPauzuVsetkym(){
        for(int i = 0; i < root.getChildren().size(); i++){
            Node my = root.getChildren().get(i);
            if (my instanceof Animal) ((Animal)my).prepniPauzu();
        }}
}