package br.com.fiap.to;

public class CertificadoTO {
    private long certificadoId;            // certificadoId: long (ID of the certificate)
    private ConsumidorTO consumidor;       // consumidor: ConsumidorTO (Reference to the consumer associated with the certificate)
    private TipoDeCertificadoTO tipoDeCertificado;  // tipoDeCertificado: TipoDeCertificadoTO (Reference to the type of certificate)
    private String nomeDoCertificado;      // nomeDoCertificado: String (Name of the certificate)
    private String descricao;              // descricao: String (Description of the certificate)
    private String metodoDeObter;
}
