package br.com.fiap.to;

public class ComentarioTO {
    private long comentarioId;          // comentarioId: long (ID of the comment)
    private UsuarioTO usuario;         // usuario: UsuarioTO (User who wrote the comment)
    private String titulo;             // titulo: String (Title of the comment)
    private String texto;              // texto: String (Text content of the comment)
    private String imagem;
    private PostTO post;
}
