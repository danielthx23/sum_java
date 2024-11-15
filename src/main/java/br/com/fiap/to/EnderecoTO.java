package br.com.fiap.to;

public class EnderecoTO {
    private Long idEndereco;        // Long
    private String nrCep;              // int (CEP)
    private int nrEndereco;         // int (number of the address)
    private String nmBairro;        // String (neighborhood)
    private String nmEstado;        // String (state)
    private String nmRua;           // String (street)
    private String dsComplemento;   // String (complementary address info)
    private UsuarioTO usuario;
}
