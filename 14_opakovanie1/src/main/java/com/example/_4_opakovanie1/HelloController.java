package com.example._4_opakovanie1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;

    @FXML public void initialize(){
        root.setOnKeyPressed(e->spracuj(e));
    }

    private void spracuj(KeyEvent e){
        KeyCode code = e.getCode();
        switch(code){
            case W: posunObjekty(); break;
            case S: zastavMuchy(); break;
        }
    }

    private void posunObjekty(){
        for(int i = 0; i<root.getChildren().size(); i++){
            Node n = root.getChildren().get(i);
            if(n instanceof Hmyz) ((Hmyz) n).posun();;
        }
    }

    private void zastavMuchy(){
        for(int i = 0; i<root.getChildren().size(); i++){
            Node n = root.getChildren().get(i);
            if(n instanceof Mucha) ((Mucha) n).zastav();;
        }
    }

    @FXML private void vytvorMucha(){
        Mucha m = new Mucha(root);
        root.getChildren().add(m);
    }

    @FXML private void vytvorChrobak(){
        Chrobak c = new Chrobak(root);
        root.getChildren().add(c);
    }
}
