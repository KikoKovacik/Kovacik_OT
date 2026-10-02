package com.example.bmi_kalkulacka;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label bmi;
    @FXML
    private TextField vyska, hmotnost;
    @FXML
    protected void vypocet() {
        double vys = Double.parseDouble(vyska.getText());
        double vah = Double.parseDouble(hmotnost.getText());
        double bmicko = Math.round(vah/(vys*vys/10000)*10)/10.0;
        if (bmicko < 18.5) bmi.setText("BMI = "+ bmicko +" - podváha");
        else if (bmicko < 25) bmi.setText("BMI = "+ bmicko +" - normálna hmotnosť");
        else if (bmicko < 30) bmi.setText("BMI = "+ bmicko +" - nadváha");
        else if (bmicko < 35) bmi.setText("BMI = "+ bmicko +" - obezita 1. stupňa");
        else if (bmicko < 40) bmi.setText("BMI = "+ bmicko +" - obezita 2. stupňa");
        else bmi.setText("BMI = "+ bmicko +" - obezita 3. stupňa (ťažká)");
    }
}
