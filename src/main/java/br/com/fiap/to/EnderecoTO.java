package br.com.fiap.to;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoTO {

    private Long idEndereco;

    @Size(max = 20)
    private String numeroCep;

    private int numeroEndereco;

    @Size(max = 100)
    private String nomeBairro;

    @Size(max = 50)
    private String nomeCidade;

    @Size(max = 50)
    private String nomeEstado;

    @Size(max = 100)
    private String nomeRua;

    @Size(max = 100)
    private String complemento;

    private UsuarioTO usuario;

    public EnderecoTO() {
    }

    public EnderecoTO(Long idEndereco, String numeroCep, int numeroEndereco, String nomeBairro, String nomeCidade, String nomeEstado, String nomeRua, String complemento, UsuarioTO usuario) {
        this.idEndereco = idEndereco;
        this.numeroCep = numeroCep;
        this.numeroEndereco = numeroEndereco;
        this.nomeBairro = nomeBairro;
        this.nomeCidade = nomeCidade;
        this.nomeEstado = nomeEstado;
        this.nomeRua = nomeRua;
        this.complemento = complemento;
        this.usuario = usuario;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public @Size(max = 20) String getNumeroCep() {
        return numeroCep;
    }

    public void setNumeroCep(@Size(max = 20) String numeroCep) {
        this.numeroCep = numeroCep;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public @Size(max = 100) String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(@Size(max = 100) String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public @Size(max = 50) String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(@Size(max = 50) String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public @Size(max = 50) String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(@Size(max = 50) String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public @Size(max = 100) String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(@Size(max = 100) String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public @Size(max = 100) String getComplemento() {
        return complemento;
    }

    public void setComplemento(@Size(max = 100) String complemento) {
        this.complemento = complemento;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }
}
