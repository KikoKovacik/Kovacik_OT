package com.example.semafor;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    Semafor s;

    @FXML protected void draw() {
        s = new Semafor();
        root.getChildren().add(s);
    };
    @FXML protected void manual() {
        s.zmenStav();
    };
    @FXML protected void automatic(){
        s.prepni();
    };
    @FXML protected void turnOff() {
        s.vypni();
    };
    @FXML protected void turnOn() {
        s.zapni();
    };

}