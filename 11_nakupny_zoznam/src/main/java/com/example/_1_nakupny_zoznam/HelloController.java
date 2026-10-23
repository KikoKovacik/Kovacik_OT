package com.example._1_nakupny_zoznam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tfpolozka;
    @FXML private TextField tfpocet;
    @FXML private Label lblcelkovo;
    @FXML private ListView<Polozka> list;
    private ObservableList<Polozka> zoznam = FXCollections.observableArrayList();

    @FXML private void initialize(){
        list.setItems(zoznam);
        aktualizujLabel();
    }

    private void aktualizujLabel(){
        int celkovo = zoznam.size();
        if (celkovo==1) lblcelkovo.setText("CELKOVO "+celkovo+" POLOŽKA");
        else if (celkovo>1&&celkovo<5) lblcelkovo.setText("CELKOVO "+celkovo+" POLOŽKY");
        else lblcelkovo.setText("CELKOVO "+celkovo+" POLOŽIEK");
    }

    @FXML protected void pridanie(){
        String nazov = tfpolozka.getText();
        int pocet;
        pocet = Integer.parseInt(tfpocet.getText());
        if (nazov.isEmpty() || pocet<=0) return;
        zoznam.add(new Polozka(nazov, pocet));
        tfpolozka.clear();
        tfpocet.clear();
        aktualizujLabel();
    }

    @FXML protected void zmazanie(){
        int i = list.getSelectionModel().getSelectedIndex();
        if (i<0) return;
        zoznam.remove(i);
        tfpolozka.clear();
        tfpocet.clear();
        aktualizujLabel();
    }

    @FXML protected void uprava(){
        Polozka p = list.getSelectionModel().getSelectedItem();
        if (p==null) return;
        String nazov = tfpolozka.getText();
        int pocet;
        pocet = Integer.parseInt(tfpocet.getText());
        if (nazov.isEmpty() || pocet<=0) return;
        p.setNazov(nazov);
        p.setPocet(pocet);
        list.refresh();
        tfpolozka.clear();
        tfpocet.clear();
        aktualizujLabel();
    }

    @FXML protected void nahod(){
        Polozka p = list.getSelectionModel().getSelectedItem();
        if (p==null) return;
        tfpolozka.setText(p.getNazov());
        tfpocet.setText(String.valueOf(p.getPocet()));
    }
}