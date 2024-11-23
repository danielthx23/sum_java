package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;

public class UsuarioLoginTO {

    private Long idUsuario;

    @NotNull
    @Size(max = 50)
    private String nomeUsuario;

    @Size(max = 100)
    private String razaoSocial;

    @Size(max = 19)
    private String cnpj;

    @Size(max = 11)
    private String cpf;

    @NotNull
    @Size(max = 50)
    private String tipoConta;

    @Size(max = 500)
    private String imagemFoto;

    @NotNull
    @Size(min = 6, max = 500)
    private String numeroSenha;

    @Size(max = 500)
    private String valorToken;

    @NotNull
    private Timestamp dataCadastro;

    private List<ComentarioTO> comentarios;

    private List<PostTO> posts;

    private List<EnderecoTO> enderecos;

    private List<EmailTO> emails;

    private List<TelefoneTO> telefones;

    private ConsumidorTO consumidor;

    private FornecedorTO fornecedor;

    public UsuarioLoginTO() {
    }

    public UsuarioLoginTO(Long idUsuario, String nomeUsuario, String razaoSocial, String cnpj, String cpf, String tipoConta, String imagemFoto, String numeroSenha, String valorToken, Timestamp dataCadastro, List<ComentarioTO> comentarios, List<PostTO> posts, List<EnderecoTO> enderecos, List<EmailTO> emails, List<TelefoneTO> telefones, ConsumidorTO consumidor, FornecedorTO fornecedor) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.tipoConta = tipoConta;
        this.imagemFoto = imagemFoto;
        this.numeroSenha = numeroSenha;
        this.valorToken = valorToken;
        this.dataCadastro = dataCadastro;
        this.comentarios = comentarios;
        this.posts = posts;
        this.enderecos = enderecos;
        this.emails = emails;
        this.telefones = telefones;
        this.consumidor = consumidor;
        this.fornecedor = fornecedor;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotNull @Size(max = 50) String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(@NotNull @Size(max = 50) String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public @Size(max = 100) String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@Size(max = 100) String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public @Size(max = 19) String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@Size(max = 19) String cnpj) {
        this.cnpj = cnpj;
    }

    public @Size(max = 11) String getCpf() {
        return cpf;
    }

    public void setCpf(@Size(max = 11) String cpf) {
        this.cpf = cpf;
    }

    public @NotNull @Size(max = 50) String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(@NotNull @Size(max = 50) String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public @Size(max = 500) String getImagemFoto() {
        return imagemFoto;
    }

    public void setImagemFoto(@Size(max = 500) String imagemFoto) {
        this.imagemFoto = imagemFoto;
    }

    public @NotNull @Size(min = 6, max = 500) String getNumeroSenha() {
        return numeroSenha;
    }

    public void setNumeroSenha(@NotNull @Size(min = 6, max = 500) String numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    public @Size(max = 500) String getValorToken() {
        return valorToken;
    }

    public void setValorToken(@Size(max = 500) String valorToken) {
        this.valorToken = valorToken;
    }

    public @NotNull Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(@NotNull Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<ComentarioTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioTO> comentarios) {
        this.comentarios = comentarios;
    }

    public List<PostTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostTO> posts) {
        this.posts = posts;
    }

    public List<EnderecoTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoTO> enderecos) {
        this.enderecos = enderecos;
    }

    public List<EmailTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailTO> emails) {
        this.emails = emails;
    }

    public List<TelefoneTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneTO> telefones) {
        this.telefones = telefones;
    }

    public ConsumidorTO getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(ConsumidorTO consumidor) {
        this.consumidor = consumidor;
    }

    public FornecedorTO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorTO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String gerarToken(String campo, String senha) {
        return campo + "." + senha;
    }
}
