package com.example.kalkulacka;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML private Label operacia, vysledok;

    private double ulozene = 0;
    private String op = "";

    @FXML protected void nula(){
        operacia.setText(operacia.getText()+"0");
    }
    @FXML protected void jeden(){
        operacia.setText(operacia.getText()+"1");
    }
    @FXML protected void dva(){
        operacia.setText(operacia.getText()+"2");
    }
    @FXML protected void tri(){
        operacia.setText(operacia.getText()+"3");
    }
    @FXML protected void styri(){
        operacia.setText(operacia.getText()+"4");
    }
    @FXML protected void pat(){
        operacia.setText(operacia.getText()+"5");
    }
    @FXML protected void sest(){
        operacia.setText(operacia.getText()+"6");
    }
    @FXML protected void sedem(){
        operacia.setText(operacia.getText()+"7");
    }
    @FXML protected void osem(){
        operacia.setText(operacia.getText()+"8");
    }
    @FXML protected void devat(){
        operacia.setText(operacia.getText()+"9");
    }

    private void spracuj(){
        if (operacia.getText().isEmpty()) return;

        double cislo = Double.parseDouble(operacia.getText());

        if (op.isEmpty()){
            ulozene = cislo;
        }
        else if (op.equals("+")){
            ulozene = ulozene + cislo;
        }
        else if (op.equals("-")){
            ulozene = ulozene - cislo;
        }
        else if (op.equals("*")){
            ulozene = ulozene * cislo;
        }
        else if (op.equals("/")){
            ulozene = ulozene / cislo;
        }

        if (ulozene == (long) ulozene){
            vysledok.setText(String.valueOf((long) ulozene));
        }
        else{
            vysledok.setText(String.valueOf(ulozene));
        }
        operacia.setText("");
    }

    @FXML protected void sucet(){
        spracuj();
        op = "+";
    }
    @FXML protected void rozdiel(){
        spracuj();
        op = "-";
    }
    @FXML protected void sucin(){
        spracuj();
        op = "*";
    }
    @FXML protected void podiel(){
        spracuj();
        op = "/";
    }
    @FXML protected void rovnasa(){
        spracuj();
        op = "";
    }
}