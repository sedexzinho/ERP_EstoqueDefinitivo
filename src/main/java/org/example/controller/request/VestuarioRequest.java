package org.example.controller.request;

import org.example.model.Vestuario;

public class VestuarioRequest extends AProdutoRequest {

    private String tamanho;
    private String cor;
    private String tecido;

    public VestuarioRequest() {
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    public void exibirInfo() {
        System.out.println("**************************************");
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Preco de custo: " + getPrecoCusto());
        System.out.println("Preco de venda: " + getPrecoVenda());
        System.out.println("Quantidade estoque: " + getQuantidadeEstoque());
        System.out.println("**************************************");

    }
}
