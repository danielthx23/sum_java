package br.com.fiap.to;

import java.sql.Timestamp;

public class PostCategoriaTO {
    private long postCategoriaId;      // postCategoriaId: long (ID of the post category)
    private String tipo;               // tipo: String (Type of the category, e.g., Technology, Environment)
    private String descricao;          // descricao: String (Description of the category)
    private Timestamp dataDeCadastro;
}
