package org.example.controller.request;

public class EletrodomesticoRequst extends AProdutoRequest {
    private String marca;
    private String modelo;
    private String cor;
    private int voltagemSuportada;
    private int potenciaWatts;

    public double getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(double pesoKG) {
        this.pesoKG = pesoKG;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVoltagemSuportada() {
        return voltagemSuportada;
    }

    public void setVoltagemSuportada(int voltagemSuportada) {
        this.voltagemSuportada = voltagemSuportada;
    }

    public int getPotenciaWatts() {
        return potenciaWatts;
    }

    public void setPotenciaWatts(int potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
    }

    private double pesoKG;

}
