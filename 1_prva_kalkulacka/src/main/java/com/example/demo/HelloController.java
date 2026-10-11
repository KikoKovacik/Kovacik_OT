package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private Label labelresult;
    @FXML private TextField textfield1, textfield2;

    @FXML protected void sucet(){
        int a = Integer.parseInt(textfield1.getText());
        int b = Integer.parseInt(textfield2.getText());
        labelresult.setText(String.valueOf(a+b));
        textfield1.clear();
        textfield2.clear();
    }
    @FXML protected void rozdiel(){
        int a = Integer.parseInt(textfield1.getText());
        int b = Integer.parseInt(textfield2.getText());
        labelresult.setText(String.valueOf(a-b));
        textfield1.clear();
        textfield2.clear();
    }
    @FXML protected void sucin(){
        int a = Integer.parseInt(textfield1.getText());
        int b = Integer.parseInt(textfield2.getText());
        labelresult.setText(String.valueOf(a*b));
        textfield1.clear();
        textfield2.clear();
    }
    @FXML protected void podiel(){
        int a = Integer.parseInt(textfield1.getText());
        int b = Integer.parseInt(textfield2.getText());
        labelresult.setText(String.valueOf(a/b));
        textfield1.clear();
        textfield2.clear();
    }
    @FXML protected void desatinnypodiel(){
        int a = Integer.parseInt(textfield1.getText());
        int b = Integer.parseInt(textfield2.getText());
        labelresult.setText(String.valueOf((double)a/b));
        textfield1.clear();
        textfield2.clear();
    }
}