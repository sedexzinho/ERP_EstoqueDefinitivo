package org.example.model;

public class Alimenticio extends Produto {
    private String dataValidade;
    private String materialEmbalagem;
    private Double peso;

    public Alimenticio() {

    }

    public Alimenticio(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque, String dataValidade, String materialEmbalagem, Double peso) {
        super(codigo, nome, precoCusto, precoVenda, quantidadeEstoque);
        this.dataValidade = dataValidade;
        this.materialEmbalagem = materialEmbalagem;
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getMaterialEmbalagem() {
        return materialEmbalagem;
    }

    public void setMaterialEmbalagem(String materialEmbalagem) {
        this.materialEmbalagem = materialEmbalagem;
    }


    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }


}
