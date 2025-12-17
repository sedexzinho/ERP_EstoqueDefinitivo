package org.example.model;

public class Limpeza extends Produto{
    private String volumeML;
    private String tipo;
    private String perfume;
    private boolean biodegradavel;

    public Limpeza() {
    }

    public Limpeza(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque,
                   boolean biodegradavel, String perfume, String tipo, String volumeML) {
        super(codigo, nome, precoCusto, precoVenda, quantidadeEstoque);
        this.biodegradavel = biodegradavel;
        this.perfume = perfume;
        this.tipo = tipo;
        this.volumeML = volumeML;
    }

    public String getVolumeML() {
        return volumeML;
    }

    public void setVolumeML(String volumeML) {
        this.volumeML = volumeML;
    }

    public boolean isBiodegradavel() {
        return biodegradavel;
    }

    public void setBiodegradavel(boolean biodegradavel) {
        this.biodegradavel = biodegradavel;
    }

    public String getPerfume() {
        return perfume;
    }

    public void setPerfume(String perfume) {
        this.perfume = perfume;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getNomeCategoria() {
        return "Limpeza";
    }

    @Override
    public String getNomeTabela() {
        return "produto_limpeza";
    }

    @Override
    protected void exibirAtributosEspecificos() {
        System.out.println("Biodegradavel: " + biodegradavel);
        System.out.println("Perfume: " + perfume);
        System.out.println("Tipo: " + tipo);
        System.out.println("VolumeML: " + volumeML);

    }


}
