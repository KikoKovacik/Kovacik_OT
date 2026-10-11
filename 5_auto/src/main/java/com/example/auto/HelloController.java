package com.example.auto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    Auto a;

    @FXML protected void manual(){
        if(a == null){
            a = new Auto();
            root.getChildren().add(a);
        }
        a.manual();
    }
    @FXML protected void automatika(){
        if(a == null){
            a = new Auto();
            root.getChildren().add(a);
        }
        a.automatika();
    }

}