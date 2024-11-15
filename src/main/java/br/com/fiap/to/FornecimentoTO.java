package br.com.fiap.to;

import java.sql.Timestamp;

public class FornecimentoTO {
    private long fornecimentoId;            // fornecimentoId: long (ID of the supply contract)
    private FornecedorTO fornecedor;        // fornecedor: FornecedorTO (Reference to the supplier)
    private String tipoDeContratacao;      // tipoDeContratacao: String (Type of contract, e.g., "Fixed", "Variable")
    private double precoPorKWH;            // precoPorKWH: double (Price per kilowatt-hour)
    private Timestamp dataDeVencimento;    // dataDeVencimento: Timestamp (Due date for the contract)
    private TipoDeFornecimentoTO tipoDeFornecimento;
}
