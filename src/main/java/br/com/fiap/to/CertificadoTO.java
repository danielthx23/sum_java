package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CertificadoTO {

    private Long idCertificado;

    @NotNull
    @Size(max = 50)
    private String tipoCertificado;

    @NotNull
    @Size(max = 100)
    private String nomeCertificado;

    @Size(max = 500)
    private String descricao;

    @NotNull
    @Size(max = 1000)
    private String metodoObter;

    private ConsumidorTO consumidor;

    public CertificadoTO() {
    }

    public CertificadoTO(Long idCertificado, String tipoCertificado, String nomeCertificado, String descricao, String metodoObter, ConsumidorTO consumidor) {
        this.idCertificado = idCertificado;
        this.tipoCertificado = tipoCertificado;
        this.nomeCertificado = nomeCertificado;
        this.descricao = descricao;
        this.metodoObter = metodoObter;
        this.consumidor = consumidor;
    }

    public Long getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Long idCertificado) {
        this.idCertificado = idCertificado;
    }

    public @NotNull @Size(max = 50) String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(@NotNull @Size(max = 50) String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public @NotNull @Size(max = 100) String getNomeCertificado() {
        return nomeCertificado;
    }

    public void setNomeCertificado(@NotNull @Size(max = 100) String nomeCertificado) {
        this.nomeCertificado = nomeCertificado;
    }

    public @Size(max = 500) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 500) String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @Size(max = 1000) String getMetodoObter() {
        return metodoObter;
    }

    public void setMetodoObter(@NotNull @Size(max = 1000) String metodoObter) {
        this.metodoObter = metodoObter;
    }

    public ConsumidorTO getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(ConsumidorTO consumidor) {
        this.consumidor = consumidor;
    }
}
