package com.example._2_vlakna;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController{
    @FXML public TextField txtcislo;
    @FXML public TextArea txtfaktorial;
    @FXML public TextArea txtmocnina;
    @FXML public TextArea txtfibonacci;

    @FXML public ProgressBar pbfaktorial;
    @FXML public ProgressBar pbmocnina;
    @FXML public ProgressBar pbfibonacci;

    public void spanok(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void vypis(TextArea area, int text){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                area.appendText(text+"\n");
            }
        });
    }
    private void progres(ProgressBar bar, double hodnota){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                bar.setProgress(hodnota);
            }
        });
    }

    public void vypocet(){
        int cislo = Integer.parseInt(txtcislo.getText());
        txtfaktorial.clear();
        txtmocnina.clear();
        txtfibonacci.clear();
        pbfaktorial.setProgress(0);
        pbmocnina.setProgress(0);
        pbfibonacci.setProgress(0);

        Runnable faktorialrun = new Runnable() {
            @Override
            public void run() {
                faktorial(cislo);
            }
        };

        Runnable mocninarun = new Runnable() {
            @Override
            public void run() {
                mocnina(cislo);
            }
        };

        Runnable fibonaccirun = new Runnable() {
            @Override
            public void run() {
                fibonacci(cislo);
            }
        };

        new Thread(faktorialrun).start();
        new Thread(mocninarun).start();
        new Thread(fibonaccirun).start();
    }

    public void faktorial(int cislo){
        int vysledok = 1;
        for(int i = 1; i <= cislo; i++){
            vysledok *= i;
            vypis(txtfaktorial, vysledok);
            progres(pbfaktorial, i/(double)cislo);
            spanok();
        }
    }
    public void mocnina(int cislo){
        int vysledok;
        for(int i = 1; i <= cislo; i++){
            vysledok = i*i;
            vypis(txtmocnina, vysledok);
            progres(pbmocnina, i/(double)cislo);
            spanok();
        }
    }
    public void fibonacci(int cislo){
        int vysledok;
        int prve = 0;
        int druhe = 1;
        vypis(txtfibonacci, 1);
        progres(pbfibonacci, 1/(double)cislo);
        spanok();
        for(int i = 2; i <= cislo; i++){
            vysledok = prve + druhe;
            prve = druhe;
            druhe = vysledok;
            vypis(txtfibonacci, vysledok);
            progres(pbfibonacci, i/(double)cislo);
            spanok();
        }
    }
}
