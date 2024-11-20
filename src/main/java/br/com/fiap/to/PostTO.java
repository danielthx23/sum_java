package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;

public class PostTO {

    private Long idPost;

    @NotNull
    @Size(max = 50)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @Size(max = 500)
    private String imagem;

    private Timestamp dataCadastro;

    private UsuarioTO usuario;

    private List<ComentarioTO> comentarios;

    public PostTO() {
    }

    public PostTO(Long idPost, String titulo, String descricao, String imagem, Timestamp dataCadastro, UsuarioTO usuario, List<ComentarioTO> comentarios) {
        this.idPost = idPost;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public @NotNull @Size(max = 50) String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull @Size(max = 50) String titulo) {
        this.titulo = titulo;
    }

    public @Size(max = 500) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 500) String descricao) {
        this.descricao = descricao;
    }

    public @Size(max = 500) String getImagem() {
        return imagem;
    }

    public void setImagem(@Size(max = 500) String imagem) {
        this.imagem = imagem;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public List<ComentarioTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioTO> comentarios) {
        this.comentarios = comentarios;
    }
}
