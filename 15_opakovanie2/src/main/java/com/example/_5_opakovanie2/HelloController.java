package com.example._5_opakovanie2;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML private TextField textnazov;
    @FXML private TextField textpriorita;
    @FXML private TextField textstav;
    @FXML private ListView<Uloha> lv;
    @FXML private TextArea textvystup;
    private ObservableList<Uloha> zoznam = FXCollections.observableArrayList();
    private boolean bezia = false;

    @FXML private void initialize(){
        lv.setItems(zoznam);
    }

    @FXML private void pridaj(){
        String nazov = textnazov.getText();
        String priorita = textpriorita.getText();
        String stav = textstav.getText();
        Uloha u = new Uloha(nazov, priorita, stav);
        zoznam.add(u);
        vyprazdni();
    }

    @FXML private void nahodtext(){
        Uloha u = lv.getSelectionModel().getSelectedItem();
        if (u == null) return;
        textnazov.setText(u.getNazov());
        textpriorita.setText(u.getPriorita());
        textstav.setText(u.getStav());
    }

    @FXML private void edituj(){
        Uloha u = lv.getSelectionModel().getSelectedItem();
        if (u == null) return;
        u.setNazov(textnazov.getText());
        u.setPriorita(textpriorita.getText());
        u.setStav(textstav.getText());
        lv.refresh();
        vyprazdni();
    }

    @FXML private void vymaz(){
        int i = lv.getSelectionModel().getSelectedIndex();
        if (i >= 0){
            zoznam.remove(i);
        }
    }

    private void vyprazdni(){
        textnazov.clear();
        textpriorita.clear();
        textstav.clear();
    }

    private void spanok(int milisekundy) throws InterruptedException {
        Thread.sleep(milisekundy);
    }

    private void vypisPocet(){
        int pocet = 0;
        for (Uloha u : zoznam){
            if (u.getStav().equals("rozpracovaná")){
                pocet++;
            }
        }
        textvystup.appendText("Rozpracované úlohy: " + pocet + "\n");
    }

    private void odstranHotove(){
        for (int i = zoznam.size() - 1; i >= 0; i--){
            if (zoznam.get(i).getStav().equals("hotová")){
                zoznam.remove(i);
            }
        }
    }

    @FXML private void spusti(){
        if (bezia) return;
        bezia = true;

        Runnable pocetrun = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        spanok(3000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                vypisPocet();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    // vlákno sa ukončilo
                }
            }
        };

        Runnable mazanierun = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        spanok(10000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                odstranHotove();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        Thread t1 = new Thread(pocetrun);
        Thread t2 = new Thread(mazanierun);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}