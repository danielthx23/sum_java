package br.com.fiap.to;

import java.sql.Timestamp;
import java.util.ArrayList;

public class FornecedorTO {
    private long fornecedorId;          // fornecedorId: long (ID of the supplier)
    private UsuarioTO usuario;          // usuario: UsuarioTO (Reference to the user associated with the supplier)
    private String energiaPrimaria;     // energiaPrimaria: String (Primary energy source)
    private Timestamp dataDeOperacao;   // dataDeOperacao: Timestamp (Operation start date)
    private String status;              // status: String (Current status of the supplier)
    private float capacidadeDeEnergia;  // capacidadeDeEnergia: float (Energy capacity)
    private String licenciatura;        // licenciatura: String (License information)
    private String regiao;
}
