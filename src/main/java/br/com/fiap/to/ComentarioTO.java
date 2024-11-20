package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ComentarioTO {

    private Long idComentario;

    @NotNull
    @Size(max = 100)
    private String titulo;

    @Size(max = 1000)
    private String texto;

    @Size(max = 500)
    private String imagem;

    private UsuarioTO usuario;

    private PostTO post;

    public ComentarioTO() {
    }

    public ComentarioTO(Long idComentario, String titulo, String texto, String imagem, UsuarioTO usuario, PostTO post) {
        this.idComentario = idComentario;
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.usuario = usuario;
        this.post = post;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public @NotNull @Size(max = 100) String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull @Size(max = 100) String titulo) {
        this.titulo = titulo;
    }

    public @Size(max = 1000) String getTexto() {
        return texto;
    }

    public void setTexto(@Size(max = 1000) String texto) {
        this.texto = texto;
    }

    public @Size(max = 500) String getImagem() {
        return imagem;
    }

    public void setImagem(@Size(max = 500) String imagem) {
        this.imagem = imagem;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public PostTO getPost() {
        return post;
    }

    public void setPost(PostTO post) {
        this.post = post;
    }
}
