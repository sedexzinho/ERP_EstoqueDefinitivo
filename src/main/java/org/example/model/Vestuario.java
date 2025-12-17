package org.example.model;

public class Vestuario extends Produto {
    private String tamanho;
    private String cor;
    private String tecido;

    public Vestuario() {

    }

    public Vestuario(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque,
                     String tamanho, String cor, String tecido) {
        super(codigo, nome, precoCusto, precoVenda, quantidadeEstoque);
        this.tamanho = tamanho;
        this.cor = cor;
        this.tecido = tecido;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamamaho(String tamamaho) {
        this.tamanho = tamamaho;
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String getNomeCategoria() {
        return "Vestuario";
    }

    @Override
    public String getNomeTabela() {
        return "produto_vestuario";
    }

    @Override
    protected void exibirAtributosEspecificos() {
        System.out.println("Tamamaho: " + tamanho);
        System.out.println("Cor: " + cor);
        System.out.println("Tecido: " + tecido);
    }


}
