package org.example.model;

public class Eletrodomestico extends Produto {
    private String marca;
    private String modelo;
    private String cor;
    private int voltagemSuportada;
    private int potenciaWatts;
    private double pesoKG;

    public Eletrodomestico() {

    }

    public Eletrodomestico(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque,
                           String marca, double pesoKG, int potenciaWatts, int voltagemSuportada, String cor, String modelo) {
        super(codigo, nome, precoCusto, precoVenda, quantidadeEstoque);
        this.marca = marca;
        this.pesoKG = pesoKG;
        this.potenciaWatts = potenciaWatts;
        this.voltagemSuportada = voltagemSuportada;
        this.cor = cor;
        this.modelo = modelo;
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

    @Override
    public String getNomeCategoria() {
        return "Eletrodomestico";
    }

    @Override
    public String getNomeTabela() {
        return "produto_eletrodomestico";
    }

    @Override
    protected void exibirAtributosEspecificos() {
        System.out.println("Marca: " + getMarca() );
        System.out.println("Modelo: " + getModelo() );
        System.out.println("Cor: " + getCor() );
        System.out.println("Potencia Watts: " + getPotenciaWatts() );
        System.out.println("Voltagem Suportada: " + getVoltagemSuportada() );
        System.out.println("Peso KG: " + getPesoKG() );

    }


}