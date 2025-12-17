package org.example.model;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private String descricao;

    public Categoria() {

    }

    public Categoria(int idCategoria, String nomeCategoria, String descricao) {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int codigo) {
        this.idCategoria = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nome) {
        this.nomeCategoria = nome;
    }
}
