package org.example.controller.request;

import org.example.model.Produto;

public class LimpezaRequest extends AProdutoRequest {
    private String volumeML;
    private String tipo;
    private String perfume;
    private String biodegradavel;

    public String getVolumeML() {
        return volumeML;
    }

    public void setVolumeML(String volumeML) {
        this.volumeML = volumeML;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfume() {
        return perfume;
    }

    public void setPerfume(String perfume) {
        this.perfume = perfume;
    }

    public String getBiodegradavel() {
        return biodegradavel;
    }

    public void setBiodegradavel(String biodegradavel) {
        this.biodegradavel = biodegradavel;
    }

}
