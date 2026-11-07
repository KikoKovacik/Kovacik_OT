package com.example._3_vlakna_bankovy_ucet;

public class Zamestnanec {
    private static int pocitadlo = 0;

    private int id;
    private BankovyUcet ucet;

    public Zamestnanec(BankovyUcet ucet) {
        pocitadlo++;
        this.id = pocitadlo;
        this.ucet = ucet;
    }

    public int getId() {
        return id;
    }

    public BankovyUcet getUcet() {
        return ucet;
    }
}