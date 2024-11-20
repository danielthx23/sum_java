package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class FornecimentoTO {

    private Long idFornecimento;

    @NotNull
    @Size(max = 100)
    private String tipoContrato;

    private double precoKwh;

    private Timestamp dataVencimento;

    private FornecedorTO fornecedor;

    @NotNull
    @Size(max = 100)
    private String tipoEnergia;

    @Size(max = 1000)
    private String processoObtencao;

    private String fornecimentoImagem;

    public FornecimentoTO() {
    }

    public FornecimentoTO(Long idFornecimento, String tipoContrato, double precoKwh, Timestamp dataVencimento, FornecedorTO fornecedor, String tipoEnergia, String processoObtencao, String fornecimentoImagem) {
        this.idFornecimento = idFornecimento;
        this.tipoContrato = tipoContrato;
        this.precoKwh = precoKwh;
        this.dataVencimento = dataVencimento;
        this.fornecedor = fornecedor;
        this.tipoEnergia = tipoEnergia;
        this.processoObtencao = processoObtencao;
        this.fornecimentoImagem = fornecimentoImagem;
    }

    public Long getIdFornecimento() {
        return idFornecimento;
    }

    public void setIdFornecimento(Long idFornecimento) {
        this.idFornecimento = idFornecimento;
    }

    public @NotNull @Size(max = 100) String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(@NotNull @Size(max = 100) String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public double getPrecoKwh() {
        return precoKwh;
    }

    public void setPrecoKwh(double precoKwh) {
        this.precoKwh = precoKwh;
    }

    public Timestamp getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Timestamp dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public FornecedorTO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorTO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public @NotNull @Size(max = 100) String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(@NotNull @Size(max = 100) String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public @Size(max = 1000) String getProcessoObtencao() {
        return processoObtencao;
    }

    public void setProcessoObtencao(@Size(max = 1000) String processoObtencao) {
        this.processoObtencao = processoObtencao;
    }

    public String getFornecimentoImagem() {
        return fornecimentoImagem;
    }

    public void setFornecimentoImagem(String fornecimentoImagem) {
        this.fornecimentoImagem = fornecimentoImagem;
    }
}
