package com.example._3_vlakna_bankovy_ucet;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML public TextField txtpociatocny;
    @FXML public Label lblzostatok;
    @FXML public ComboBox<String> cmboperacia;
    @FXML public TextField txtsuma;
    @FXML public TextArea txtvypis;

    private BankovyUcet ucet;

    @FXML
    public void initialize() {
        cmboperacia.getSelectionModel().selectFirst();
        txtpociatocny.setText("1000");
        ucet = new BankovyUcet(1000);
        lblzostatok.setText("1000 €");
    }

    public void spanok(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void vypis(String text) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtvypis.appendText(text + "\n");
            }
        });
    }

    private void zobrazZostatok() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lblzostatok.setText(ucet.getSuma() + " €");
            }
        });
    }

    public void vytvorUcet() {
        try {
            int zostatok = Integer.parseInt(txtpociatocny.getText());
            ucet = new BankovyUcet(zostatok);
            lblzostatok.setText(zostatok + " €");
            txtvypis.appendText("Vytvorený nový účet so zostatkom " + zostatok + " €\n");
        } catch (NumberFormatException e) {
            txtvypis.appendText("Zadaj platný počiatočný zostatok.\n");
        }
    }

    public void operacia(Zamestnanec z, String typ, int suma) {
        spanok((int) (Math.random() * 500));
        if (typ.equals("Vklad")) {
            int zostatok = z.getUcet().vklad(suma);
            vypis("Zamestnanec " + z.getId() + ": vklad " + suma + " €, zostatok " + zostatok + " €");
        } else {
            int zostatok = z.getUcet().vyber(suma);
            if (zostatok >= 0) {
                vypis("Zamestnanec " + z.getId() + ": výber " + suma + " €, zostatok " + zostatok + " €");
            } else {
                vypis("Zamestnanec " + z.getId() + ": výber " + suma + " € zamietnutý, nedostatok prostriedkov");
            }
        }
        zobrazZostatok();
    }

    public void runOne() {
        int suma;
        try {
            suma = Integer.parseInt(txtsuma.getText());
        } catch (NumberFormatException e) {
            txtvypis.appendText("Zadaj platnú sumu.\n");
            return;
        }
        String typ = cmboperacia.getValue();
        Zamestnanec zamestnanec = new Zamestnanec(ucet);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                operacia(zamestnanec, typ, suma);
            }
        };
        new Thread(run).start();
    }

    public void runFive() {
        for (int i = 0; i < 5; i++) {
            Zamestnanec zamestnanec = new Zamestnanec(ucet);
            String typ;
            if (Math.random() < 0.5) {
                typ = "Vklad";
            } else {
                typ = "Výber";
            }
            int suma = (int) (Math.random() * 500) + 1;

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    operacia(zamestnanec, typ, suma);
                }
            };
            new Thread(run).start();
        }
    }
}