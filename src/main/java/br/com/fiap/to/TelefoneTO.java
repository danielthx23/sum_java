package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TelefoneTO {

        private Long idTelefone;

        @NotBlank
        @Size(max = 20)
        private String numeroTelefone;

        @NotBlank
        @Size(max = 10)
        private String DDD;

        @NotBlank
        @Size(max = 20)
        private String DDI;

        @Size(max = 500)
        private String lembrete;

        private UsuarioTO usuario;

    public TelefoneTO() {
    }

    public TelefoneTO(Long idTelefone, String numeroTelefone, String DDD, String DDI, String lembrete, UsuarioTO usuario) {
        this.idTelefone = idTelefone;
        this.numeroTelefone = numeroTelefone;
        this.DDD = DDD;
        this.DDI = DDI;
        this.lembrete = lembrete;
        this.usuario = usuario;
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public @NotBlank @Size(max = 20) String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(@NotBlank @Size(max = 20) String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public @NotBlank @Size(max = 10) String getDDD() {
        return DDD;
    }

    public void setDDD(@NotBlank @Size(max = 10) String DDD) {
        this.DDD = DDD;
    }

    public @NotBlank @Size(max = 20) String getDDI() {
        return DDI;
    }

    public void setDDI(@NotBlank @Size(max = 20) String DDI) {
        this.DDI = DDI;
    }

    public @Size(max = 500) String getLembrete() {
        return lembrete;
    }

    public void setLembrete(@Size(max = 500) String lembrete) {
        this.lembrete = lembrete;
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }
}

