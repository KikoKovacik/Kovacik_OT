package com.example._3_vlakna_bankovy_ucet;

public class BankovyUcet {
    private int suma;

    public BankovyUcet(int suma) {
        this.suma = suma;
    }

    public synchronized int vklad(int hodnota) {
        suma += hodnota;
        return suma;
    }

    public synchronized int vyber(int hodnota) {
        if (hodnota > suma) {
            return -1;
        }
        suma -= hodnota;
        return suma;
    }

    public synchronized int getSuma() {
        return suma;
    }
}