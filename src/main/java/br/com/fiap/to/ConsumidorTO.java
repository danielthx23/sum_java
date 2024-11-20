package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;

public class ConsumidorTO {

    private long consumidorId;
    
    @NotNull
    @Size(max = 100)
    private String numeroMedidor;

    private float consumoEnergetico;

    @NotNull
    @Size(max = 100)
    private String tipoConsumo;

    private float tarifa;

    @NotNull
    @Size(max = 100)
    private String classeConsumo;

    private Long idConsumidor;

    @NotNull
    private float consumoMes;

    @NotNull
    private Timestamp ultimaLeitura;

    private UsuarioTO usuario;

    private List<CertificadoTO> certificados;

    public ConsumidorTO() {
    }

    public ConsumidorTO(long consumidorId, String numeroMedidor, float consumoEnergetico, String tipoConsumo, float tarifa, String classeConsumo, Long idConsumidor, float consumoMes, Timestamp ultimaLeitura, UsuarioTO usuario, List<CertificadoTO> certificados) {
        this.consumidorId = consumidorId;
        this.numeroMedidor = numeroMedidor;
        this.consumoEnergetico = consumoEnergetico;
        this.tipoConsumo = tipoConsumo;
        this.tarifa = tarifa;
        this.classeConsumo = classeConsumo;
        this.idConsumidor = idConsumidor;
        this.consumoMes = consumoMes;
        this.ultimaLeitura = ultimaLeitura;
        this.usuario = usuario;
        this.certificados = certificados;
    }

    public long getConsumidorId() {
        return consumidorId;
    }

    public void setConsumidorId(long consumidorId) {
        this.consumidorId = consumidorId;
    }

    public @NotNull @Size(max = 100) String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(@NotNull @Size(max = 100) String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public float getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(float consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public @NotNull @Size(max = 100) String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(@NotNull @Size(max = 100) String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public @NotNull @Size(max = 100) String getClasseConsumo() {
        return classeConsumo;
    }

    public void setClasseConsumo(@NotNull @Size(max = 100) String classeConsumo) {
        this.classeConsumo = classeConsumo;
    }

    public Long getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(Long idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    @NotNull
    public float getConsumoMes() {
        return consumoMes;
    }

    public void setConsumoMes(@NotNull float consumoMes) {
        this.consumoMes = consumoMes;
    }

    public @NotNull Timestamp getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(@NotNull Timestamp ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public List<CertificadoTO> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<CertificadoTO> certificados) {
        this.certificados = certificados;
    }
}
