package com.example.ball;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    Ball b;

    @FXML protected void draw(){
        b = new Ball();
        root.getChildren().add(b);
        b.start();
    };

}