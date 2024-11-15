package br.com.fiap.to;

import java.sql.Timestamp;
import java.util.ArrayList;

public class UsuarioTO {
    private Long idUsuario;
    private String imgFoto;
    private String nmUsuario;
    private String razaoSocial;
    private String cnpj;
    private String cpf;
    private String flConta;
    private String nmSenha;
    private String vlToken;
    private Timestamp dtCadastro;
    private FornecedorTO fornecedor;
    private ConsumidorTO consumidor;
    private ArrayList<EnderecoTO> enderecos;
    private ArrayList<EmailTO> emails;
    private ArrayList<TelefoneTO> telefones;
}
