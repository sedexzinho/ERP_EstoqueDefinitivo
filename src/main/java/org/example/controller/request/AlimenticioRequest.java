package org.example.controller.request;

public class AlimenticioRequest extends AProdutoRequest {

    private String dataValidade;
    private String materialEmbalagem;
    private Double peso;

    public AlimenticioRequest() {
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getMaterialEmbalagem() {
        return materialEmbalagem;
    }

    public void setMaterialEmbalagem(String materialEmbalagem) {
        this.materialEmbalagem = materialEmbalagem;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
