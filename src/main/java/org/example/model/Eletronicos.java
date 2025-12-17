package org.example.model;

public class Eletronicos extends Produto {
    private String tipo;
    private int armazenamento;
    private String marca;
    private String modelo;
public Eletronicos() {}

    public Eletronicos(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque,
                       String tipo, int armazenamento, String marca, String modelo) {
        super(codigo, nome, precoCusto, precoVenda, quantidadeEstoque);
        this.marca = marca;
        this.tipo = tipo;
        this.modelo = modelo;
        this.armazenamento = armazenamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getNomeCategoria() {
        return "Eletronicos";
    }

    @Override
    public String getNomeTabela() {
        return "produto_eletronico";
    }

    @Override
    protected void exibirAtributosEspecificos() {
        System.out.println("Tipo: " + getTipo());
        System.out.println("Armazenamento: " + getArmazenamento());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());

    }
}
