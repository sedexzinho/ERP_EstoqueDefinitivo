package org.example.model;

public class Eletrodomestico extends Produto {
    private String marca;
    private String modelo;
    private String cor;
    private int voltagemSuportada;
    private int potenciaWatts;
    private double pesoKG;

    public Eletrodomestico(String codigo,
                           String nome,
                           double precoCompra,
                           Double precoVenda,
                           int quantidadeEstoque,
                           String marca,
                           String modelo,
                           String cor,
                           int voltagemSuportada,
                           int potenciaWatts,
                           double pesoKG) {
        super(codigo, nome, precoCompra, precoVenda, quantidadeEstoque);
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.potenciaWatts = potenciaWatts;
        this.pesoKG = pesoKG;
        this.voltagemSuportada = voltagemSuportada;
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

    public double getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(double pesoKG) {
        this.pesoKG = pesoKG;
    }


}