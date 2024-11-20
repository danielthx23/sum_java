package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FornecedorTO {

    @NotNull
    @Size(max = 50)
    private String licenciatura;

    @NotNull
    private float capacidade;

    @NotNull
    @Size(max = 50)
    private String status;

    private Timestamp dataOperacao;

    @NotNull
    @Size(max = 50)
    private String energiaPrimaria;

    private Long idFornecedor;

    @NotNull
    @Size(max = 50)
    private String regiao;

    private UsuarioTO usuario;

    private List<FornecimentoTO> fornecimentos;

    public FornecedorTO() {
    }

    public FornecedorTO(String licenciatura, float capacidade, String status, Timestamp dataOperacao, String energiaPrimaria, Long idFornecedor, String regiao, UsuarioTO usuario, List<FornecimentoTO> fornecimentos) {
        this.licenciatura = licenciatura;
        this.capacidade = capacidade;
        this.status = status;
        this.dataOperacao = dataOperacao;
        this.energiaPrimaria = energiaPrimaria;
        this.idFornecedor = idFornecedor;
        this.regiao = regiao;
        this.usuario = usuario;
        this.fornecimentos = fornecimentos;
    }

    public @NotNull @Size(max = 50) String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(@NotNull @Size(max = 50) String licenciatura) {
        this.licenciatura = licenciatura;
    }

    @NotNull
    public float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(@NotNull float capacidade) {
        this.capacidade = capacidade;
    }

    public @NotNull @Size(max = 50) String getStatus() {
        return status;
    }

    public void setStatus(@NotNull @Size(max = 50) String status) {
        this.status = status;
    }

    public Timestamp getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Timestamp dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public @NotNull @Size(max = 50) String getEnergiaPrimaria() {
        return energiaPrimaria;
    }

    public void setEnergiaPrimaria(@NotNull @Size(max = 50) String energiaPrimaria) {
        this.energiaPrimaria = energiaPrimaria;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public @NotNull @Size(max = 50) String getRegiao() {
        return regiao;
    }

    public void setRegiao(@NotNull @Size(max = 50) String regiao) {
        this.regiao = regiao;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public List<FornecimentoTO> getFornecimentos() {
        return fornecimentos;
    }

    public void setFornecimentos(List<FornecimentoTO> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }
}
