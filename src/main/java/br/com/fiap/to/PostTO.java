package br.com.fiap.to;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PostTO {
    private long postId;                // postId: long (ID of the post)
    private UsuarioTO usuario;          // usuario: UsuarioTO (Reference to the user who created the post)
    private String titulo;              // titulo: String (Title of the post)
    private String descricao;           // descricao: String (Description or content of the post)
    private String imagem;              // imagem: String (Image URL or file path associated with the post)
    private Timestamp dataDeCadastro;
    private ArrayList<ComentarioTO> comentarios;
    private PostCategoriaTO postCategoria;
}
