package com.example.netjob.Model;

public class Contrato {

    String linea1;
    String linea2;
    int image;

    public String getLinea1() { return linea1; }

    public void setLinea1(String linea1) {
        this.linea1 = linea1;
    }

    public String getLinea2() {
        return linea2;
    }

    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Contrato(String linea1, String linea2, int image) {
        this.linea1 = linea1;
        this.linea2 = linea2;
        this.image = image;
    }
}
